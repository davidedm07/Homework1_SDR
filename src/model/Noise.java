package model;

import java.util.Random;
// classe Rumore, identifica un rumore gaussiano bianco 
public class Noise extends AbstractSignal {
	private double varianza;
	private double pot_rumore;
	
// costruttore della classe, a partire da un certo snr genera un rumore 
	public Noise(double snr, int length) {
		super();
		Random campione = null;
		double snr_linearizzato= Math.pow(10, (snr/10));
		this.pot_rumore= (1/snr_linearizzato);

		for(int i = 0; i < length; i++) {
			campione = new Random();
			double reale = campione.nextGaussian() * Math.sqrt(pot_rumore/2);
			campione = new Random();
			double immaginario = campione.nextGaussian() * Math.sqrt(pot_rumore/2);
			Complex c=new Complex(reale,immaginario);
			super.getValues().add(c);

		}

		super.setLength(super.getValues().size());

	}

	// Getters and Setters della classe

	public double getVarianza() {
		return varianza;
	}

	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}

	public double getPot_rumore() {
		return pot_rumore;
	}

	public void setPot_rumore(double pot_rumore) {
		this.pot_rumore = pot_rumore;
	}
}
