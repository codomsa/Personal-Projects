package padure;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import controller.Run;
public class Citire {

														// metoda citire intreg din Controller.Run
	
	public static Padure[] citireTastatura() {
    	int n;
    	n=Run.citInt("cate paduri:");
    	Padure P[] = new Padure[n];						//instantiere tablou de paduri
    	
    	for(int i=0;i<n;i++) {
    		P[i]=new Padure("",1);						//instantiere element de tablou
    		
    		System.out.print("da numele padurii:");		//citire nume
    		Scanner s=new Scanner(System.in);   		
    		P[i].setNume(s.nextLine());
    		
    		
    		long arie=Run.citLong("da aria:");			//citire arie
    		P[i].setArie(arie);
    	}
    	return P;
    	
    }													// Padure Padure = new Padure("",1); 
    
//	public static void citireTastatura2() {
//		Map<String, Long> data = new HashMap<>();
//		Scanner s = new Scanner(System.in);
//		
//		while (true) {
//			System.out.print("Introduceti nume padure: ");
	//			String nume = s.nextLine();
	//			if (nume.equals ("break")) 
	//				break;
	//			
	//			
	//			System.out.print("Introduceti aria:");
	//			Long arie = s.nextLong();
	//			
	//			data.put(nume, arie);
	//		}
	//		s.close();
		
//		for (Map.Entry<String, Long> entry : data.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//	}
    
    public static Padure[] citireFisier(String fileName) {
    	List<Padure> paduri = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    		String linie;
    		while ((linie = br.readLine()) != null) {
    			String[] partial = linie.split(" ");
    			paduri.add(new Padure (partial [0], Long.parseLong(partial[1])));
    		}
    		return paduri.toArray(new Padure[paduri.size()]);
    	} catch (IOException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}

	
