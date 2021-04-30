package it.unibs.fp.codicefiscale;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Comune {

	private String nome;
	private String codice;
	public static ArrayList<String> codiciComuni = Comune.leggiCodiciComuni();

	/**
	 * dato un codice restituisce true se valido , false altrimenti
	 * 
	 * @param codice
	 * @return
	 */
	public static boolean isValid(String codice) {
		return codiciComuni.contains(codice);
	}

	/**
	 * restituisce il codice (letto da comuni.xml) del nome del comune sempre se
	 * esiste
	 * 
	 * @param nome
	 * @return
	 * @throws XMLStreamException
	 */
	public static String getCodiceComune(String nome){
		String codiceComune = "";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = factory.newDocumentBuilder();
			Document doc = Builder.parse("comuni.xml");

			NodeList list = doc.getElementsByTagName("comune");

			for (int i = 0; i < list.getLength(); i++) {
				Node n = list.item(i);
				Element e = (Element) n;
				String nomeComune = e.getElementsByTagName("nome").item(0).getTextContent();
				if (nomeComune.equals(nome)) {
					codiceComune = e.getElementsByTagName("codice").item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			System.out.println("Errore");
		}
		return codiceComune;
	}

	public static ArrayList<String> leggiCodiciComuni() {
		ArrayList<String> codici = new ArrayList<String>();
		/*
		 * try { DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 * DocumentBuilder Builder = factory.newDocumentBuilder(); Document doc =
		 * Builder.parse("comuni.xml"); NodeList list =
		 * doc.getElementsByTagName("comune");
		 * 
		 * for (int i = 0; i < list.getLength(); i++) { Node n = list.item(i); Element e
		 * = (Element) n;
		 * codici.add(e.getElementsByTagName("codice").item(0).getTextContent()); } }
		 * catch (Exception e) {
		 * System.out.println("Errore nella creazione della lista di codici"); }
		 */
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String codice = "non funziona", temp = null;
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
			while (xmlr.hasNext()) {
				switch (xmlr.getEventType()) {
				case XMLStreamConstants.START_DOCUMENT:
					break;
				case XMLStreamConstants.START_ELEMENT:
					temp = xmlr.getLocalName();
					break;
				case XMLStreamConstants.END_ELEMENT:
					break;
				case XMLStreamConstants.COMMENT:
					break;
				case XMLStreamConstants.CHARACTERS:
					if (temp.equals("codice")) {
						codice = xmlr.getText();
						codici.add(codice);
					}
					temp = "";
					break;
				default:
					break;
				}
				xmlr.next();
			}
		} catch (Exception e) {
			System.out.println("nope");
			System.out.println(e.getMessage());
		}
		return codici;
	}

	/**
	 * restituisce true se il comune è valido (presente nel comuni.xml) false
	 * altrimenti
	 * 
	 * @param comune
	 * @return
	 * @throws XMLStreamException
	 */
	/*
	 * public static boolean isValidComune(String comune) throws XMLStreamException
	 * { boolean esiste = false;
	 * 
	 * try { DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	 * DocumentBuilder Builder = factory.newDocumentBuilder(); Document doc =
	 * Builder.parse("comuni.xml");
	 * 
	 * NodeList list = doc.getElementsByTagName("comune");
	 * 
	 * for (int i = 0; i < list.getLength(); i++) {
	 * 
	 * Node n = list.item(i); Element e = (Element) n;
	 * 
	 * String nomeComune = e.getElementsByTagName("nome").item(0).getTextContent();
	 * 
	 * if (nomeComune.equals(comune)) { return true; } } } catch (Exception e) {
	 * System.out.println("Errore"); }
	 * 
	 * return esiste; }
	 */
}

