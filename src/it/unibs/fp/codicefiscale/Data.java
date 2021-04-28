package it.unibs.fp.codicefiscale;

import java.util.Scanner;

public class Data {
	
	private int day ;
	private int month ;
	private int year ;
	
	public Data(int _day , int _month , int _year) {
		this.day = _day ;
		this.month = _month ;
		this.year = _year ;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * estrae da una data stringa (yyyy-MM-dd) i singoli valori e restituisce un oggetto di tipo Data
	 * 
	 * @param data
	 * @return Data
	 */
	public static Data estraiData (String data){
		
		Scanner scanner = new Scanner (data) ;
		scanner.useDelimiter("-");
		int anno = 0 , mese = 0 , giorno = 0 , i = 0 ;
		
		while (scanner.hasNext()) {
			
			if (scanner.hasNextInt()) {
				switch (i)
				{
				case 0 :
					anno = scanner.nextInt();
					i++;
					break;
				case 1 :
					mese = scanner.nextInt();
					i++;
					break;
				case 2 :
					giorno = scanner.nextInt();
					break;
				} 
			} else { 
				scanner.next();
				}
		} scanner.close();
		
		Data birthday = new Data (giorno, mese , anno);
		return birthday ;
	}
	
}
