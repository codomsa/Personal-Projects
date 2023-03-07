package padure;

import padure.Padure;

//public class Padure implements Comparable<Padure> {
public class Padure {
	private String nume;											//date membru (starea clasei)
	private long Arie;
	
	public Padure(String nume, long Arie) {							//constr. cu parametri
		this.nume=nume;
		this.Arie=Arie;
	}
																	//metode (interfata clasei)
	public String getNume() {										//accesori	de tip get	
		return nume;
	}
	public long getArie() {
		return Arie;
	}
	public void setNume(String nume) {								//accesori de tip set
		this.nume = nume;
	}
	public void setArie(long Arie) {
		if(Arie<=0) this.Arie=1;
		else           this.Arie = Arie;
	}
//	public boolean maiMare(Padure f) {		  						//comparare arii v1 cum am facut la seminar
//		if(Arie>f.Arie) return true;   		 						//ob.maiLung(ob1) / nefolosit
//		else                  return false;
//	}
	public boolean maiMicAlfa(Padure f) {      						//comparator pt sortarea alfabetica
		int I=  nume.compareTo(f.nume);
		if(I<0)       return true;
		              return false;
	}
	
	public int compareTo(Padure altaPadure) {						//comparator pentru arii 1/0/-1
		return Long.compare(getArie(), altaPadure.getArie());
	}
}



