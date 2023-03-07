package view;
import padure.*;

public class Sort {
    public static void sortareAlfabetic(Padure f[]) {
    	for(int i=0;i<f.length-1;i++)						//tehnica selectiei
    		for(int j=i+1;j<f.length;j++) 
    			if(!f[i].maiMicAlfa(f[j])) {				//numele lui f[i]> numele lui f[j]
    				Padure aux= f[i];
    				f[i]=f[j];
    				f[j]=aux;
    			}
    }
    public static void sortareArie(Padure f[]) {
    	for(int i=0;i<f.length-1;i++)						//tehnica selectiei
    		for(int j=i+1;j<f.length;j++) { 
    			if(f[i].compareTo(f[j]) < 0) {
    				Padure aux = f[i];
    				f[i]=f[j];
    				f[j]=aux;
    				
    			}
    		}
    }
}
