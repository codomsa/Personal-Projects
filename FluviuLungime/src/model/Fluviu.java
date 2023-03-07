package model;

public class Fluviu {
	private String nume;		//date membru (starea clasei)
	private int lungime;
	
	public Fluviu(String nume, int lungime) {//constr. cu parametri
		this.nume=nume;
		this.lungime=lungime;
	}
								//metode (interfata clasei)
	public String getNume() {			//accesori	de tip get	
		return nume;
	}
	public int getLungime() {
		return lungime;
	}
	public void setNume(String nume) {	//accesori de tip set
		this.nume = nume;
	}
	public void setLungime(int lungime) {
		if(lungime<=0) this.lungime=1;
		else           this.lungime = lungime;
	}
	public boolean maiLung(Fluviu f) {		  //comparare a lungimilor
		if(lungime>f.lungime) return true;    //ob.maiLung(ob1)
		else                  return false;
	}
	public boolean maiMicAlfa(Fluviu f) {      //ob.maiMicAlfa(ob1)
		int I=  nume.compareTo(f.nume);
		if(I<0)       return true;
		              return false;
	}
}


