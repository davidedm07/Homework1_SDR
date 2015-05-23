package signalProcessing;

import java.math.*;
import model.AbstractSignal;
import model.Noise;
import model.Signal;

/**
 * Classe che offre servizi di processamento di segnali
 * @author Davide Di Maria
 *
 */
public class SignalProcessor {

	/*calcola la funzione di errore inversa*/

	public static double invErf(double d) throws Exception {

		if (Math.abs(d)>1) {
			throw new Exception ("Allowed values for argument in [-1,1]");
		}

		if (Math.abs(d) == 1) {
			return (d==-1 ? Double.NEGATIVE_INFINITY :
				Double.POSITIVE_INFINITY);
		}
		else {
			if (d==0) {
				return 0;
			}

			BigDecimal bd = new BigDecimal(0, MathContext.UNLIMITED);
			BigDecimal x = new BigDecimal(d*Math.sqrt(Math.PI)/2,MathContext.UNLIMITED);
			//System.out.println(x);

			String[] A092676 = {"1", "1", "7", "127", "4369", "34807",
					"20036983", "2280356863", 
					"49020204823", "65967241200001",
					"15773461423793767", "655889589032992201",
					"94020690191035873697", "655782249799531714375489",
					"44737200694996264619809969", "10129509912509255673830968079", 
					"108026349476762041127839800617281", "10954814567103825758202995557819063",
					"61154674195324330125295778531172438727", "54441029530574028687402753586278549396607",
					"452015832786609665624579410056180824562551", 
					"2551405765475004343830620568825540664310892263",
					"70358041406630998834159902148730577164631303295543", 
					"775752883029173334450858052496704319194646607263417",	
			"132034545522738294934559794712527229683368402215775110881"};



			String[] A092677 = {"1", "3", "30", "630", "22680", "178200",
					"97297200", "10216206000", 
					"198486288000", "237588086736000",
					"49893498214560000", "1803293578326240000",
					"222759794969712000000", "1329207696584271504000000",
					"77094046401887747232000000", "14761242414008506896480000000", 
					"132496911908140357902804480000000", "11262237512191930421738380800000000",
					"52504551281838779626144331289600000000", "38905872499842535702972949485593600000000",
					"268090886133368733415443853598208000000000", "1252532276140582782027102181569679872000000000",
					"28520159927721069946757116674341610685440000000000", 
					"259078091444256105986928093487086396226560000000000",
			"36256424429074976496234665114956818633529712640000000000"};

			for (int i = 0; i < A092676.length; i++) {                
				BigDecimal num = new BigDecimal(new BigInteger(A092676[i]),50);
				BigDecimal den = new BigDecimal(new BigInteger(A092677[i]),	50);
				BigDecimal coeff = num.divide(den, RoundingMode.HALF_UP);
				//System.out.println(coeff);
				BigDecimal xBD = x.pow(i*2+1, MathContext.UNLIMITED);          
				bd = bd.add(xBD.multiply(coeff, MathContext.UNLIMITED));       
			}    

			return bd.doubleValue();            
		}
	}
/**
 * Metodo che calcola offline la soglia per determinare la probabulit� di detection di un 
 * segnale 
 * @param x
 * @param snr
 * @param numeroTentativi
 * @param pFa
 * @return double soglia
 * @throws Exception
 */
	public static double soglia(int x ,double snr, int numeroTentativi,double pFa) throws Exception {
		double[] values=new double[numeroTentativi];
		for (int i=0; i< numeroTentativi;i++) {
			Noise r= new Noise(snr,x);
			values[i]=r.signalEnergy();			
		}
		
		double soglia = mean (values) + (Math.sqrt(2*varianza(values))*invErf(1-2*pFa));
		return soglia;

	}
/**
 * Calcola la media di un array di double
 * @param v
 * @return double
 */
	public static double mean(double[] v) {
		double m=0;
		for (int i=0; i<v.length; i++)
			m += v[i];

		return m/v.length;	
	}

	/**
	 * Calcola la varianza di un array di double
	 * @param v
	 * @return double
	 */
	public static double varianza(double[] v) {
		double m = mean(v);
		double sommaScartiQuad = 0;
		for(int i=0; i<v.length; i++)
			sommaScartiQuad += (v[i]-m)*(v[i]-m);
		return sommaScartiQuad/v.length;
	}
/**
 * Calcola la percentuale di detection di un segnale di un Primary User 
 * @param x
 * @param numeroTentativi
 * @param pFa
 * @return
 * @throws Exception
 */
	public static double energyDetection (AbstractSignal x,int numeroTentativi,double pFa) throws Exception {
		double probDetection=0;
		int n=1000;
		double[] energie=new double[n];
		double snr=snr(x);
		System.out.println("Snr="+snr);
		double soglia=soglia(n,snr,numeroTentativi,pFa);
		System.out.println("Soglia="+soglia);
		double detection=0;
		for (int i=0; i<1000; i++) {
			int z=i*n;
			AbstractSignal y= new Signal(x.getValues().subList(z,z+n));
			double energia=y.signalEnergy();
			energie[i]=energia;
			if (energia>soglia)
				detection++;
		}
		probDetection=detection/10.0;
		return probDetection;
	}

/**
 * Calcola il rapporto segnale-rumore di un segnale passato in input
 * @param x
 * @return double 
 */

	private static double snr(AbstractSignal x) {
		double energia=x.signalEnergy();
		double snr = 1/(energia-1);
		snr= 10* Math.log10(snr);
		return snr;
	}
}
