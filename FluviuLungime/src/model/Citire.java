package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import controller.Run;
public class Citire {

	// metoda cu Scanner de citire intreg din Controller.Run
	
	public static Fluviu[] citireTastatura() {
    	int n;
    	n=Run.citIntreg("cate fluvii:");
    	Fluviu f[] = new Fluviu[n];				//instantiere tablou de fluvii
    	
    	for(int i=0;i<n;i++) {
    		f[i]=new Fluviu("",1);				//instantiere element de tablou
    		
    		System.out.print("da numele fluviului:");//citire nume
    		Scanner s=new Scanner(System.in);   		
    		f[i].setNume(s.nextLine());
    		
    		
    		int lung=Run.citIntreg("da lungime:");	//citire lungime
    		f[i].setLungime(lung);
    	}
    	return f;
    	
    }								// Fluviu fluviu = new Fluviu("",1); 
    
    
    public static Fluviu[] citireFisier() {
    	BufferedReader fisIn = 
		new BufferedReader(new FileReader("c:\\Users\\Cioban\\eclipse-workspace\\FluviuLungime\\src\\Model\\fluvii.txt"));
		String s;
		s=fisIn.readLine();
		int n=Integer.parseInt(s);		//m=numarul de linii
		Fluviu []f=new Fluviu[n];
		
		for(int i=1;i<=m; i++){
			  s = fisIn.readLine();
			  String lab[]=s.split(",");
   	  
			  for(int j=1;j<=n;j++){
				  ???=Integer.parseInt(lab[j-1]);
			  }
		  }

		
    	return f;
    }
}
