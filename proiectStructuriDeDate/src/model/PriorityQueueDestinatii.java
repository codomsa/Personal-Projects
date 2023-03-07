package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import model.Destinatii;

public class PriorityQueueDestinatii {
    private PriorityQueue<Destinatii> queue;
    private int k;
    private double maxDistance;
    String fileName = "C:\\Users\\domsa\\eclipse-workspace\\proiectStructuriDeDate\\src\\model";
    
    public PriorityQueueDestinatii(String fileName) throws FileNotFoundException {
        queue = new PriorityQueue<>();
        Scanner s = new Scanner(new File(fileName));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] elements = line.split(" ");
            String name = elements[0];
            int coordinateX = Integer.parseInt(elements[1]);
            int coordinateY = Integer.parseInt(elements[2]);
            queue.offer(new Destinatii(name, coordinateX, coordinateY));
        }
        
    }

    public static void addDestinatie(PriorityQueue<Destinatii> pq) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the name of the destination: ");
        String name = s.next();
        System.out.print("Enter the X coordinate: ");
        int x = s.nextInt();
        System.out.print("Enter the Y coordinate: ");
        int y = s.nextInt();
        pq.add(new Destinatii(name, x, y));
        System.out.println("Destination added successfully!");
    }

    public static void closestKDestinations(PriorityQueue<Destinatii> pq) {
    	
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the value of K: ");
    	int k = s.nextInt();

    	System.out.println("Closest " + k + " destinations:");
    	PriorityQueue<Destinatii> temp = new PriorityQueue<>(pq);
    	for (int i = 0; i < k; i++) {
    		Destinatii d = temp.poll();
    		System.out.println(d.getName() + " " + d.getDistance());
    	}
	}
    public static void destinationsWithinMaxDistance(PriorityQueue<Destinatii> pq) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the value of M: ");
        double m = s.nextDouble();

        int count = 0;
        PriorityQueue<Destinatii> temp = new PriorityQueue<>(pq);
        while (!temp.isEmpty() && temp.peek().getDistance() <= m) {
            temp.poll();
            count++;
        }

        System.out.println("Number of destinations reachable in max distance " + m + ": " + count);
    }
}
       