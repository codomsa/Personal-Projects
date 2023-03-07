package controller;

import java.util.Scanner;

import padure.*;
import view.*;

public class Run {
		
	public static long citLong(String prompter) {							//citirea unui intreg
		System.out.print(prompter);											//utilizare try si catch
		try {																//cu apel recursiv
			Scanner s=new Scanner(System.in);
			long I=s.nextLong();											//parsare=analiza si conversie
			return I;
		}
		catch(Exception e) {
			System.out.println("ai gresit optiunea");
			citLong(prompter);												//apelul recursiv
		}
		return 0;
	}
	
	public static int citInt(String prompter) {								//citirea unui intreg
		System.out.print(prompter);											//utilizare try si catch
		try {																//cu apel recursiv
			Scanner s=new Scanner(System.in);
			int I=s.nextInt();												//parsare=analiza si conversie
			return I;
		}
		catch(Exception e) {
			System.out.println("ai gresit optiunea");
			citLong(prompter);												//apelul recursiv
		}	
		return 0;
	}
	public static int meniu() {
    	System.out.println();
    	System.out.println("1.Citire date(tastatura)");
	    System.out.println("2.Citire date(din fisier)");
	    System.out.println("3.Afisare alfabetica");
	    System.out.println("4.Afisare procentuala, arie");
	    System.out.println("0.Terminare program");
	    return citInt("alege o optiune:");
	}
		
	public static void main(String[] args) {
		int opt=meniu();
		Padure[] tablou=null;
		while(opt!=0) {
			switch(opt) {
				case 1: 													//citirea datelor de la tastatura
						tablou=Citire.citireTastatura();
					    break;
				case 2: 													//citirea datelor din fisier
					    tablou=Citire.citireFisier("C:\\Users\\domsa\\eclipse-workspace\\Padure\\src\\padure\\padure.txt");
					    break;
				case 3: if(tablou!=null) {									//metoda pentru afisarea datelor sortate alfabetic
					     	Sort.sortareAlfabetic(tablou);
					     	Afis.afisareAlfabetic(tablou);
				         }
					     break;
				case 4: if(tablou!=null) {									//metoda pentru sortarea datelor dupa arii
					       Sort.sortareArie(tablou);
					       Afis.afisareArie(tablou);
				        }
					    break;
			    default:System.out.println("Ai gresit optiunea, mai incearca");	   
			}
			opt=meniu();
		}
		System.out.println("Program terminat");
	}
}

