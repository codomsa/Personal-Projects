package view;
import model.*;

public class Sort {
    public static void sortareAlfa(Fluviu f[]) {
    	for(int i=0;i<f.length-1;i++)				//tehnica selectiei
    		for(int j=i+1;j<f.length;j++) 
    			if(!f[i].maiMicAlfa(f[j])) {		//numele lui f[i]> numele lui f[j]
    				Fluviu aux= f[i];
    				f[i]=f[j];
    				f[j]=aux;
    			}
    }
    public static void sortareLungimi(Fluviu f[]) {
    	for(int i=0;i<f.length-1;i++)				//tehnica selectiei
    		for(int j=i+1;j<f.length;j++) 
    			if(!f[i].maiLung(f[j])) {		//numele lui f[i]> numele lui f[j]
    				Fluviu aux= f[i];
    				f[i]=f[j];
    				f[j]=aux;
    			}
    }
}
