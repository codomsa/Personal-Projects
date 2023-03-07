package atractiiTuristiceDeVizitat;

import view.PriorityQueueDestinatii;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import model.Destinatie;


public class atractiiTuristiceDeVizitat {
	private static Scanner s = new Scanner (System.in);
	public static void main(String[] args) {
		String filePath = "C:\\Users\\domsa\\eclipse-workspace\\atractiiTuristiceDeVizitat\\src\\model\\destinatii.txt"; //declaram o variabila pt path
		PriorityQueue<Destinatie> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getDistance(), a.getDistance()));
		
		int opt;
	 	do {
	 		System.out.println("\nMenu:");
	 		System.out.println("1. Citire locatii din fisier");
	 		System.out.println("2. Afisare cele mai apropiate locatii");
	 		System.out.println("3. Adaugare locatie noua");
	 		System.out.println("4. Distanta maxima pe care doriti sa o parcurgeti");
	 		System.out.println("5. Exit");
	 		System.out.print("Choose an option: ");
	 		opt = s.nextInt();
	 		s.nextLine();
	 		switch (opt) {
	 			case 1:
	 				try {
	 					pq=PriorityQueueDestinatii.citireQueue(filePath);
	 				} catch (FileNotFoundException e) {
	 					e.printStackTrace();
	 				}
	 				break; 				//am optat pentru o citire din fisier ca sa nu stam la fiecare iterare sa scriem 10 destinatii
	 			case 2:
	 				PriorityQueueDestinatii.closestKDestinations(pq);
	 				break; 				//apelam o metoda care ne afiseaza cele mai apropiate K destinatii folosind un PriorityQueue temp
	 			case 3:
	 				PriorityQueueDestinatii.addDestinatie(pq);
	 				break;				//apelam o metoda care ne adauga o destinatie noua in queue
	 			case 4:
	 				PriorityQueueDestinatii.destinationsWithinMaxDistance(pq);
	 				break;				//apelam o metoda ce ne arata ce putem vizita in dist maxima M folosind un PriorityQueue temp
	 			case 5:
	 				System.out.println("Goodbye!");
	 				break;
	 			default:
	 				System.out.println("Invalid option, try again.");
	 		}
	 	} while (opt != 5);
	}	
}
