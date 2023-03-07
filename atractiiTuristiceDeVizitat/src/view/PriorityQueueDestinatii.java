package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import model.Destinatie;

public class PriorityQueueDestinatii {
    private static PriorityQueue<Destinatie> queue;
    
    public static PriorityQueue<Destinatie> citireQueue(String fileName) throws FileNotFoundException {
        queue = new PriorityQueue<>();
        Scanner s = new Scanner(new File(fileName));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] elements = line.split(" ");
            String name = elements[0];
            int coordinateX = Integer.parseInt(elements[1]);
            int coordinateY = Integer.parseInt(elements[2]);
            queue.offer(new Destinatie(name, coordinateX, coordinateY));
         
        }
        return queue;
        
    }

    public static void addDestinatie(PriorityQueue<Destinatie> pq) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the name of the destination: ");
        String name = s.next();
        System.out.print("Enter the X coordinate: ");
        int x = s.nextInt();
        System.out.print("Enter the Y coordinate: ");
        int y = s.nextInt();
        pq.add(new Destinatie(name, x, y));
        System.out.println("Destination added successfully!");
    }

    public static void closestKDestinations(PriorityQueue<Destinatie> pq) {
    	
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the value of K: ");
    	int k = s.nextInt();

    	System.out.println("Closest " + k + " destinations:");
    	PriorityQueue<Destinatie> temp = new PriorityQueue<>(pq);
    	for (int i = 0; i < k; i++) {
    		Destinatie d = temp.poll();
    		System.out.println(d.getName() + " " + d.getDistance());
    	}
	}
    public static void destinationsWithinMaxDistance(PriorityQueue<Destinatie> pq) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter the value of M: ");
        double m = s.nextDouble();

        int count = 0;
        double distMax=0;
        PriorityQueue<Destinatie> temp = new PriorityQueue<>(pq);
        while (!temp.isEmpty() && distMax<= m) {
        	distMax = distMax + (2*temp.peek().getDistance());
        	if(distMax<=m) {
            temp.poll();
            count++;
        	}
        }

        System.out.println("Number of destinations reachable in max distance " + m + ": " + count);
    }
}