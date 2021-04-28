package it.unibs.fp.codicefiscale;

public class Persona {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String comune;
	private String sesso;
	private Data compleanno;
	
	public Persona(String nome, String cognome, String comune, String sesso, String compleanno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.comune = comune;
		this.sesso = sesso;
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
		return comune;
	}
	public String getSesso() {
		return sesso;
	}
	public Data getCompleanno() {
		return compleanno; 
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public void setCompleanno(Data compleanno) {
		this.compleanno = compleanno;
	}
	
	
}
