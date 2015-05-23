package model;

import java.util.List;

public class Signal extends AbstractSignal {

	public Signal() {
		super();
	}

	public Signal(List<Complex> l) {
		super.setValues(l);
		super.setLength(l.size());

	}
	public Signal(int length) {
		super();
		double reale;
		double immaginario;
		super.setLength(length);
		for(int i = 0; i < length; i++) {
			double v = Math.random();
			if(v < 0.5)
				reale = 1/Math.sqrt(2);
			else
				reale = -1/Math.sqrt(2);
			double p = Math.random();
			if(p < 0.5)
				immaginario = 1/Math.sqrt(2);
			else
				immaginario = -1/Math.sqrt(2);

			Complex c=new Complex(reale,immaginario);
			super.getValues().add(c);
		}
	}
}





