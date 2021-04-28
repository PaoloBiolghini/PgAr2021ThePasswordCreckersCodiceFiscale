package it.unibs.fp.codicefiscale;

<<<<<<< HEAD
import javax.swing.*;
=======

>>>>>>> main
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

public class MainLettura {

<<<<<<< HEAD
	public static void main(String[] args) throws XMLStreamException {
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
					System.out.println("Tag " +xmlr.getLocalName());
					for(int i=0; i< xmlr.getAttributeCount();i++)
						System.out.printf(" -> attributo %s->%s%n", xmlr.getAttributeLocalName(i),xmlr.getAttributeValue(i));
					break;
				case XMLStreamConstants.END_DOCUMENT:
					System.out.println("end-tag: " + xmlr.getLocalName());
					break;
				case XMLStreamConstants.COMMENT:
					System.out.println("commento "+xmlr.getText());break;
				case XMLStreamConstants.CHARACTERS:
					if(xmlr.getText().trim().length() >0)
						System.out.println("->" +xmlr.getText());
					break;
			}
			xmlr.next();
		}
		/*
=======
	public static void main(String[] args) {
		
>>>>>>> main
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder=factory.newDocumentBuilder();
			Document doc=Builder.parse("inputPersone.xml");
<<<<<<< HEAD


=======
			
>>>>>>> main
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
<<<<<<< HEAD

		 */
=======
		
>>>>>>> main
	}
	
	
	
}






