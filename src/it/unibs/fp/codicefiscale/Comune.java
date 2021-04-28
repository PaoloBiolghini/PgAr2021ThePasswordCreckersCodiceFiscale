package it.unibs.fp.codicefiscale;

<<<<<<< HEAD
=======
<<<<<<< HEAD
public class Comune {
    String nome;
    String cod;
=======
>>>>>>> Christian
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Comune {
	
	String nome ;
	String codice ;
	
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
	public static boolean isValid(String nome){
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
				
				if(nomeComune.equals(nome)) {
					
					return true;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Errore");
		}
		return esiste ;
	}
	
	/**
	 * restituisce il codice (letto da comuni.xml) del nome del comune sempre se esiste
	 * @param nome
	 * @return
	 */
	public static String getCodiceComune(String nome){
		String codiceComune = "" ;
		if (Comune.isValid(nome)) {
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
	
<<<<<<< HEAD
=======
>>>>>>> main
>>>>>>> Christian
}
