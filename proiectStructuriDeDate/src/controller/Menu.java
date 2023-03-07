package controller;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;

import model.*;

public class Menu {
	private static Scanner s = new Scanner (System.in);
	
	public static void main(String[] args) throws Exception {
		
		String filePath = "C:\\Users\\domsa\\eclipse-workspace\\proiectStructuriDeDate\\src\\model\\atractii.txt";
		Scanner f = new Scanner(new File(filePath));
		PriorityQueue<Destinatii> pq = new PriorityQueue<>((a, b) -> Double.compare(a.getDistance(), b.getDistance()));
		
		while (f.hasNextLine()) {
			String[] partial = s.nextLine().split(" ");
			pq.add(new Destinatii(partial[0], Integer.parseInt(partial[1]), Integer.parseInt(partial[2])));
		}
		int opt= 0;
		do {
			System.out.println("1. Adauga destinatie");
			System.out.println("2. Afiseaza cele mai apropiate K destinatii");
			System.out.println("3. Afiseaza numarul maxim de destinatii ce se pot parcurge in distanta maxima M");
			System.out.println("4. Exit");
			System.out.print("Optiune: ");
			opt = s.nextInt();

			opt = s.nextInt();
	 		switch (opt) {
	 			case 1:
	 				PriorityQueueDestinatii.addDestinatie(pq);
	 				break;
	 			case 2:
	 				PriorityQueueDestinatii.closestKDestinations(pq);
	 				break;
	 			case 3:
	 				PriorityQueueDestinatii.destinationsWithinMaxDistance(pq);
	 				break;
	 			case 4:
	 				System.out.println("Goodbye!");
	 				break;
	 			default:
	 				System.out.println("Invalid option, try again.");
	 		}
	 	} while (opt != 4);
	 	s.close();	
	}
}
