package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Classe astratta che rappresenta un segnale 
 * @author Davide Di Maria
 *
 */
public abstract class AbstractSignal {

	private int length;
	private List<Complex> values;
	
// costruttore no arg della classe
	public AbstractSignal() {
       this.values=new ArrayList<>();
	}
	
// Getters and Setters della classe
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Complex> getValues() {
		return values;
	}

	public void setValues(List<Complex> values) {
		this.values = values;
	}
	
	// metodo che calcola l'energia di un segnale 
	public double signalEnergy() {
		double value=0;
		for(int i =0 ; i<length;i++) {
			Complex c = this.values.get(i);
			value += Math.pow(c.abs(),2);
		}

		return value/length;

	}

	@Override
	public String toString() {
		String desc="";
		for (int i=0; i<this.values.size();i++)
			desc += this.values.get(i).toString()+"\n";
		return desc;
		
	}

}
