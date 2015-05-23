package main;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import signalProcessing.SignalProcessor;
import model.Complex;
import model.Signal;

public class Main {

	public static void main(String[] args) throws Exception {
		FileReader f=new FileReader("C:/Users/Davide Di Maria/Documents/Libri-documenti universit�/3 ANNO/SDR/Sequenza_3/output_4.dat");
		BufferedReader br= new BufferedReader(f);
		List<Complex> l=new ArrayList<>();
		String line=br.readLine();
        //int cont=0; // numero di campioni del segnale che si vuole prendere in esame
        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Inserisci il numero di campioni su cui effettuare il test");;;;;
//        cont =keyboard.nextInt();

		while (line != null ){

			String[] str =line.split("\t");
			double x= Double.parseDouble(str[0]);
			double y= Double.parseDouble(str[1]);
			Complex c=new Complex(x,y);
			l.add(c);
			line=br.readLine();
			

		}


		Signal x=new Signal(l);
		
		System.out.println("Inserisci il numero di Tentativi");
		int numeroTentativi = keyboard.nextInt();
		System.out.println("Inserisci la probabilit� di falso allarme");
		double pFa=keyboard.nextDouble();
		double probabilita=0;
		System.out.println("Energia Segnale=" +x.signalEnergy());
		probabilita=SignalProcessor.energyDetection(x,numeroTentativi, pFa);
		keyboard.close();
        System.out.println("La probabilit� di detection � :");
		System.out.println(probabilita);




	}

}
