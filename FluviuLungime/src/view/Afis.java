package view;
import model.Fluviu;

public class Afis {
	public static void afisareAlfa(Fluviu f[]) {
		capTabelAlfa();
		///String s[]=new String[2];
		for(int i=0;i<f.length;i++) {
			System.out.format("|%-15s|%8d |\n",f[i].getNume(),f[i].getLungime());
	    }               //%10.2f
		linie(27);
   }
   public static void capTabelAlfa() {
	   linie(27);
	   System.out.println("|  nume fluviu  | lungime |");
	   linie(27);
   }
   public static void linie(int nrSemne) {
	   for(int i=0;i<nrSemne;i++)
		   System.out.print("=");
	   System.out.println();
   }
   public static void afisareLungimi(Fluviu f[]) {
	   capTabelLungimi();
	   int maxLung=f[0].getLungime();
	   for(int i=1; i<f.length;i++)
		   if(f[i].getLungime()>maxLung)
			   maxLung=f[i].getLungime();
	   for(int i=0;i<f.length;i++) {
			System.out.format("|%-15s|%8d | %7.2f |\n",
					f[i].getNume(),f[i].getLungime(),f[i].getLungime()*1.0/maxLung*100);
	    }               
		linie(37);
   }
   public static void capTabelLungimi() {
	   linie(37);
	   System.out.println("|  nume fluviu  | lungime | Procent |");
	   linie(37);
   }
   
}
