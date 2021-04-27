package it.unibs.fp.codicefiscale;

import java.util.ArrayList;

public class ControlloCodiceFiscale {

	private ArrayList<String> nome=new ArrayList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(controllaCodice("FSTPLA98M01B157E"));
	}
	
	
	//metodo invocato per controllare il codice fiscale
	//ritorna true se il codice è corretto
	//ritorna false se è presente un qualche tipo di errore
	public static boolean controllaCodice(String codice)
	{
if(codice.length()!=16) return false;
		
		if(controlloLettere(codice.substring(0,3))==false) return false;
		
		if(controlloLettere(codice.substring(3,6))==false) return false;
		
		if(controlloNumeri(codice.substring(6,8))==false) return false;
		
		if(controlloLettere(codice.substring(8,9))==false) return false;
		
		if(controlloNumeri(codice.substring(9,11))==false) return false;
		
		if(controlloLettere(codice.substring(11,12))==false) return false;
		
		if(controlloNumeri(codice.substring(12,15))==false) return false;
		
		if(controlloLettere(codice.substring(15,16))==false) return false;
		
		if(controlloGiorno(codice.substring(8,9),Integer.parseInt(codice.substring(9,11)))==false)return false;
		
		return true;
	}
	
	//controlla che siano composte solamente da lettere
	//se è presente almeno un simbolo diverso da lettere ritorna false
	public static boolean controlloLettere(String lettere){
		for(int i=0;i<lettere.length();i++){
			if(!Character.isLetter(lettere.charAt(i)))
					{
						return false;
					}
		}
		
		return true;
	}
	
	//metodo che riceve una stringa e controlla se questa è composta solamente
	//da numeri e in questo caso ritorna true e se invece è composta anche da almeno un carattere
	//diverso da un numero ritorna false
	public static boolean controlloNumeri(String numeri){
		for(int i=0;i<numeri.length();i++)
		{
			if(numeri.charAt(i)<'0' || numeri.charAt(i)>'9')
					{
						return false;
					}
		}
		
		return true;
	}

	
	public static boolean controlloGiorno(String mese,int giorno)
	{
		System.out.println("mese"+mese+"  giorno: "+giorno);
		return true;
	}
}
