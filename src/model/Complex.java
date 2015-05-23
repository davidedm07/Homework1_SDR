package model;

public class Complex {

	private double parteRe;
	private double parteImm;
	
	public Complex() {
		
	}

	public Complex(double pRe, double pImm) {
		super();
		this.parteRe = pRe;
		this.parteImm = pImm;
	}

	public double getpRe() {
		return parteRe;
	}

	public void setpRe(double pRe) {
		this.parteRe = pRe;
	}

	public double getpImm() {
		return parteImm;
	}

	public void setpImm(double pImm) {
		this.parteImm = pImm;
	}

	// metodi dei complessi

	public void  Complessoconiugato() {
		this.parteImm= - this.parteImm;
	}

	/**
	 * Calcolo del modulo di un numero complesso visto come la radice quadrata
	 * del quadrato della parte reale + il quadrato della parte immaginaria
	 * @return double
	 */
	public double abs(){
		return Math.hypot(this.parteRe, this.parteImm);
		
		//alternativa: Math.sqrt(Math.pow(this.reale,2) + Math.pow(this.immaginario,2));
	}


	@Override
	public String toString() {
		return "Complex [parteRe=" + parteRe + ", parteImm=" + parteImm + "]";
	}

	public static Complex sum (Complex c1, Complex c2) {
		double pRe= c1.getpRe() + c2.getpRe();
		double pImm=c1.getpImm() + c2.getpImm();
		return new Complex(pRe,pImm);

	}

	public static Complex product (Complex c1, Complex c2) {
		double pRe= (c1.getpRe()*c2.getpRe()) - (c1.getpImm()*c2.getpImm());
		double pImm=(c1.getpRe()*c2.getpImm())+ (c1.getpImm()*c2.getpRe());
		return new Complex(pRe,pImm);
	}

	public double phase() {
		return Math.atan2(this.parteImm,this.parteRe);
	}

	public static Complex division(Complex x, Complex y) {
		
		double Pre= x.getpRe()*y.getpRe()-x.getpImm()*y.getpImm();
		double Pimm=x.getpImm()*y.getpRe()+y.getpImm()*x.getpRe();
		double frazione= Math.pow(y.getpImm(), 2)+Math.pow(y.getpRe(), 2);
		Complex div=new Complex(Pre/frazione,Pimm/frazione);

		return div;
	}

}
