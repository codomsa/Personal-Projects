package view;
import padure.Padure;

public class Afis {
	public static void afisareAlfabetic(Padure f[]) {
		capTabelAlfabetic();
		for(int i=0;i<f.length;i++) {
			System.out.format("|%-15s|%8d |\n",f[i].getNume(),f[i].getArie());
	    }               
		linie(27);
   }
   public static void capTabelAlfabetic() {
	   linie(27);
	   System.out.println("|  nume padure  | arie |");
	   linie(27);
   }
   public static void linie(int nrSemne) {
	   for(int i=0;i<nrSemne;i++)
		   System.out.print("=");
	   System.out.println();
   }
   public static void afisareArie(Padure f[]) {
	   capTabelArie();
	   long total=0;
	   long maxArie=f[0].getArie();
	   for(int i=0; i<f.length;i++) {
		   if(f[i].getArie()>maxArie)
			  maxArie=f[i].getArie();
	   total=total+f[i].getArie();
	   }
	   
	   for(int i=0;i<f.length;i++) {
			System.out.format("|%-15s|%8d | %7.2f |\n",
				f[i].getNume(),f[i].getArie(),f[i].getArie()*100.0/total);
	    }               
		linie(37);
   }
   public static void capTabelArie() {
	   linie(37);
	   System.out.println("|  nume padure  | arie | Procent |");
	   linie(37);
   }
   
}
