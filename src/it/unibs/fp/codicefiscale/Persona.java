package it.unibs.fp.codicefiscale;

public class Persona {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String comune1;
	private String sesso1;
	private Data compleanno;

	
	public Persona(String nome, String cognome, String comune1, String sesso, String compleanno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.comune1 = comune1;
		this.sesso1 = sesso;
		this.compleanno = Data.estraiData(compleanno) ;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getComune() {
		return comune1;
	}
	public String getSesso() {
		return sesso1;
	}
	
	public String getCompleanno() {
		String data=compleanno.getDay()+"-"+compleanno.getMonth()+"-"+compleanno.getYear();
		return data; 
	}

//chiedere se è buona cosa mettere questo metodo in persona o farlo nel main, chiedere per la classe comune come faccio a prenderlo,e per la data,
	//per la differenza nel utilizzo tra string e string buffer
	public StringBuffer codice(String nome, String cognome, char sesso, Comune comune) {
		StringBuffer codiceFiscale = new StringBuffer();
		//prime 3 lettere del cognome
		if (cognome.length() < 3) {
			codiceFiscale.append(cognome);
			codiceFiscale.append("X");
		} else codiceFiscale.append(lastNametLetters(cognome));

		//lettere nome

		if(nome.length()<3){
			codiceFiscale.append(nome);
			codiceFiscale.append("X");
		}else codiceFiscale.append(nameLetters(nome));



		return codiceFiscale;
	}

	private StringBuffer consonant(String checkCon){ //restituisce una stringa contenente le consonanti
		StringBuffer cons = new StringBuffer();

		for (int i = 0; i < checkCon.length(); i++)
			if (isConsonant(checkCon.charAt(i))) {
				cons.append(checkCon.charAt(i));
			}
		return cons;
	}

private StringBuffer vowel(String checkVow){ //restituisce una stringa contenente le vocali
	StringBuffer vow = new StringBuffer();
	for (int i = 0; i < checkVow.length(); i++)
		if (!isConsonant(checkVow.charAt(i))) {
			vow.append(checkVow.charAt(i));
		}
		return vow;
}


	private StringBuffer lastNametLetters(String check) {
		StringBuffer lett = new StringBuffer(3);

		StringBuffer lastNameCons=new StringBuffer(consonant(check));
		lett.append(lastNameCons);
		if(lastNameCons.length()<3){
			StringBuffer lastNameVow=new StringBuffer(vowel(check));
			int i=0;
			while (lett.length()<3){
				lett.append(lastNameVow.charAt(i));
				i++;
			}
		}

			return lett;


	}

	private StringBuffer nameLetters(String check){
		StringBuffer lett = new StringBuffer(3);

		StringBuffer nameCons=new StringBuffer(consonant(check));
		if(nameCons.length()>=4){
			lett.append(nameCons.charAt(0));
			lett.append(nameCons.charAt(2));
			lett.append(nameCons.charAt(3));
		}else if(nameCons.length()==3){
			for (int i=0;i<3;i++)
			lett.append(nameCons.charAt(i));

		}else if(nameCons.length()<2){
			StringBuffer nameVow=new StringBuffer(vowel(check));
			int i=0;
			while (lett.length()<3){
				lett.append(nameVow.charAt(i));
				i++;
			}
		}

return lett;


	}

	private int numConsonant(String check){
		int cont=0;
		for(int i=0;i<check.length();i++){
			if(isConsonant(check.charAt(i)))
				cont++;
		}

		return cont;
	}

	private boolean isConsonant(char check) {
		String vocali = "aeiouAEIOU";
		return (vocali.indexOf(check) == -1) ? true : false;
	}

}
