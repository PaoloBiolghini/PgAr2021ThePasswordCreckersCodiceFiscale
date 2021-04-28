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
	
	public int getLastTwoDigitsYear()
	{
		return this.year % 100 ;
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
					break;
				case 1 :
					mese = scanner.nextInt();
					break;
				case 2 :
					giorno = scanner.nextInt();
					break;
				} 
				i++;
			} else { 
				scanner.next();
				}
		} scanner.close();
		
		Data birthday = new Data (giorno, mese , anno);
		return birthday;
	}
	
	public static String mese (int mese) {
		switch (mese)
		{
		case 1 : return "A" ;
		case 2 : return "B" ;
		case 3 : return "C" ;
		case 4 : return "D" ;
		case 5 : return "E" ;
		case 6 : return "H" ;
		case 7 : return "L" ;
		case 8 : return "M" ;
		case 9 : return "P" ;
		case 10 : return "R" ;
		case 11 : return "S" ;
		case 12 : return "T" ;
		default : return "";
		}
	}
	
}
