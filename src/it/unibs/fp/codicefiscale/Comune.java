package it.unibs.fp.codicefiscale;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Comune {
	
	private String nome ;
	private String codice ;
	public static ArrayList <String> codiciComuni = Comune.leggiCodiciComuni();
	
	
	public Comune(String _nome , String _codice){
		this.nome = _nome ;
		this.codice = _codice ;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCodice() {
		return codice;
	}
	/**
	 * dato una Stringa (presumibilmente di un comune) restituisce vero se è presente in comuni.xml, false altrimenti
	 * @param nome
	 * @return
	 */


	public static boolean isValid(String codice){
		return codiciComuni.contains(codice);
		
	}
	
	/**
	 * restituisce il codice (letto da comuni.xml) del nome del comune sempre se esiste
	 * @param nome
	 * @return
	 */
	public static String getCodiceComune(String nome){
		String codiceComune = "NON ESISTE" ;
		if (Comune.isValidComune(nome)) {
			try{
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
				DocumentBuilder Builder=factory.newDocumentBuilder();
				Document doc=Builder.parse("comuni.xml");
				
				NodeList list=doc.getElementsByTagName("comune");
				
				for(int i=0;i<list.getLength();i++){
					
					Node n=list.item(i);
					Element e=(Element)n;
					
					String nomeComune = e.getElementsByTagName("nome").item(0).getTextContent() ;
					
					if(nomeComune.equals(nome)) {
						codiceComune = e.getElementsByTagName("codice").item(0).getTextContent() ;
					}
				}
			}
			catch(Exception e) {
				System.out.println("Errore");
			}
		}
		return codiceComune ;
	}

	public static ArrayList <String> leggiCodiciComuni() {
		ArrayList <String> codici = new ArrayList <String> ();
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder=factory.newDocumentBuilder();
			Document doc=Builder.parse("comuni.xml");
			NodeList list=doc.getElementsByTagName("comune");
			
			for(int i=0;i<list.getLength();i++){
				Node n=list.item(i);
				Element e=(Element)n;
				codici.add(e.getElementsByTagName("codice").item(0).getTextContent());
			}
		}
		catch(Exception e) {
			System.out.println("Errore nella creazione della lista di codici");
		}	
		return codici ;
	}
	
	public static boolean isValidComune(String comune) {
		boolean esiste = false ;
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder=factory.newDocumentBuilder();
			Document doc=Builder.parse("comuni.xml");
			
			NodeList list=doc.getElementsByTagName("comune");
			
			for(int i=0;i<list.getLength();i++){
				
				Node n=list.item(i);
				Element e=(Element)n;
				

				String nomeComune = e.getElementsByTagName("nome").item(0).getTextContent() ;
				
				if(nomeComune.equals(comune)) {
					return true;
				}
			}
		}
		
		catch(Exception e) {
			System.out.println("Errore");
		}
		return esiste ;
	}

}
