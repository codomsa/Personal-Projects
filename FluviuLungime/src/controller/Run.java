package controller;
import java.util.Scanner;

import model.*;
import view.*;

public class Run {
	
	public static int citIntreg(String prompter) {	//citirea unui intreg
		System.out.print(prompter);					//utilizare try si catch
		try {										//cu apel recursiv
			Scanner s=new Scanner(System.in);
			int I=s.nextInt();						//parsare=analiza si conversie
			return I;
		}
		catch(Exception e) {
			System.out.println("ai gresit optiunea");
			citIntreg(prompter);					//apelul recursiv
		}
		return 0;
	}
	
	public static int meniu() {
    	System.out.println();
    	System.out.println("1.Citire date(tastatura)");
    	System.out.println("2.Citire date(din fisier)");
    	System.out.println("3.Afisare alfabetica");
    	System.out.println("4.Afisare procentuala, lungimi");
    	System.out.println("0.Terminare program");
    	return citIntreg("alege o optiune:");
    }
	
	public static void main(String[] args) {
		int opt=meniu();
		Fluviu[] tablou=null;
		while(opt!=0) {
			switch(opt) {
				case 1: 							//citirea datelor de la tastatura (din Model)
					    tablou=Citire.citireTastatura();
					    break;
				case 2: 							//citirea datelor din fisier
					    tablou=Citire.citireFisier();
					    break;
				case 3: if(tablou!=null) {							//apelul unei metode afisare alfabetica din View
					     	Sort.sortareAlfa(tablou);
					     	Afis.afisareAlfa(tablou);
				         }
					     break;
				case 4: if(tablou!=null) {
					       Sort.sortareLungimi(tablou);
					       Afis.afisareLungimi(tablou);
				        }
					    break;
			    default:System.out.println("Ai gresit optiunea, mai incearca");	   
			}
			opt=meniu();
		}
		System.out.println("Program terminat");
	}

}
