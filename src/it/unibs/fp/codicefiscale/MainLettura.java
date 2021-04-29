package it.unibs.fp.codicefiscale;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;

public class MainLettura {

	public static void main(String[] args) throws XMLStreamException {
//comune costruttore vuoto, chaimo metodo per generare ogni volta una stringa?
		ArrayList<String> codici=new ArrayList<>();
		String nome,cognome;
		String c;
		Data da;

		Persona p;
		String sesso;
		ArrayList<Persona> persone=new ArrayList<>();
		XMLInputFactory xmlif=null;
		XMLStreamReader xmlr=null;

		try{

			xmlif=XMLInputFactory.newInstance();
			xmlr=xmlif.createXMLStreamReader("inputPersone.xml",new FileInputStream("inputPersone.xml"));


		}catch (Exception e){
			System.out.println("Errore inizializzazione del reader:");
			System.out.println(e.getMessage());
		}
		while(xmlr.hasNext()){
			switch (xmlr.getEventType()){
				case XMLStreamConstants.START_DOCUMENT:				//leggere cosa fa
					System.out.println("Inizio lettura file inputPerosne" ); break;
				case XMLStreamConstants.START_ELEMENT:
						switch (xmlr.getLocalName().toLowerCase()){
							case "persona":
								nome=xmlr.getAttributeLocalName(0);break;
							case "cognome":
								cognome=xmlr.getAttributeLocalName(0);break;
							case "sesso":
								sesso=xmlr.getAttributeLocalName(0);break;
							case "comune_nascita":
								c=Comune.getCodiceComune(xmlr.getAttributeLocalName(0));break;
							case "data_nascita":
							da=Data.estraiData(xmlr.getAttributeLocalName(0));break;


						}
					System.out.println("Tag " +xmlr.getLocalName());
					for(int i=0; i< xmlr.getAttributeCount();i++)
						System.out.printf(" -> attributo %s->%s%n", xmlr.getAttributeLocalName(i),xmlr.getAttributeValue(i));
					break;
				case XMLStreamConstants.END_ELEMENT:
					System.out.println("end-tag: " + xmlr.getLocalName());
					break;
				case XMLStreamConstants.COMMENT:
					System.out.println("commento "+xmlr.getText());break;
				case XMLStreamConstants.CHARACTERS:
					if(xmlr.getText().trim().length() >0)
						System.out.println("->" +xmlr.getText());
					break;
			}
			//System.out.println("---------");
			xmlr.next();
		}
		/*
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder=factory.newDocumentBuilder();
			Document doc=Builder.parse("inputPersone.xml");


			NodeList list=doc.getElementsByTagName("persona");
			System.out.println(".................................");
			
			for(int i=0;i<list.getLength();i++)
			{
				Node n=list.item(i);
				System.out.println(n.getNodeName());
				Element e=(Element)n;
				System.out.println("nome:"+e.getElementsByTagName("nome").item(0).getTextContent());
			}
		}

		catch(Exception e) {
			System.out.println("something doesn't work");
		}

		 */
	}

}
