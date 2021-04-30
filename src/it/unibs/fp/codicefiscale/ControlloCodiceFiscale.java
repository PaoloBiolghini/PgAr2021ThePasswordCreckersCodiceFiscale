package it.unibs.fp.codicefiscale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ControlloCodiceFiscale {
	/**
	 * metodo invocato per controllare il codice fiscale
	 * ritorna true se il codice � corretto
	 * ritorna false se � presente un qualche tipo di errore
	 * 
	 * @param codice
	 * @return
	 */
	public static boolean controllaCodice(String codice)
	{
		char lastChr=codice.charAt(15);
		String cod=codice.substring(0,16);
         if(codice.length()!=16) return false;
		
		if(!controlloLettere(codice.substring(0,3))) return false;
		
		if(!controlloLettere(codice.substring(3,6))) return false;
		
		if(!controlloNumeri(codice.substring(6,8))) return false;
		
		if(!controlloLettere(codice.substring(8,9))) return false;
		
		if(!controlloNumeri(codice.substring(9,11))) return false;
		
		if(!controlloLettere(codice.substring(11,12))) return false;
		
		if(!controlloNumeri(codice.substring(12,15))) return false;
		
		if(!controlloLettere(codice.substring(15,16))) return false;
		
		if(!controlloGiorno(codice.substring(8,9),Integer.parseInt(codice.substring(9,11))))return false;
		
		if(!controlloComune(codice.substring(11,15))) return false;
		
//		if(Persona.interoControllo(cod)!=lastChr) return false;
		return true;
	}
	

	/**
	 * controlla che siano composte solamente da lettere
	 * se � presente almeno un simbolo diverso da lettere ritorna false
	 * 
	 * @param lettere
	 * @return
	 */
	public static boolean controlloLettere(String lettere){
		for(int i=0;i<lettere.length();i++){
			if(!Character.isLetter(lettere.charAt(i)))
					{
						return false;
					}
		}
		
		return true;
	}
	
	
	/**
	 * metodo che riceve una stringa e controlla se questa � composta solamente
	 * da numeri e in questo caso ritorna true e se invece � composta anche da almeno un carattere
	 * diverso da un numero ritorna false
	 * 
	 * @param numeri
	 * @return
	 */
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


	/**
	 * metodo che prende in input la porzione di codice fisclae mese e giorno
	 * selezione il massimo dei giorni in base al mese e controlla
	 * ritorna false se il giorno � maggiore del massimo giorno possibile
	 * ritorno true se � inferiore o uguale al massimo
	 * @param mese
	 * @param giorno
	 * @return
	 */
	public static boolean controlloGiorno(String mese,int giorno)
	{
		
		int maxgiorni=0;
		switch(mese) {
		case "B":maxgiorni=28;break;
		case "A","C","E","L","M","R","T":maxgiorni=31;break;
		case "D","H","P","S":maxgiorni=30; break;
		default: return false;
		
		}
		
		if((giorno>=1 && giorno<=maxgiorni)||(giorno>=41 && giorno<=maxgiorni+40))
			{
			 return true;
			}else {
				return false;
			}
		
		
		
	}
	
	
	/**
	 * metodo che passa al metodo della classe comune il codice comune
	 * ritorna true se il codice � stato trovato
	 * ritorna false se non � trovato il codice comune
	 * 
	 * @param codice
	 * @return
	 */
	public static boolean controlloComune(String codice) {
		
		
		return Comune.isValid(codice);
		
	}
	
}
