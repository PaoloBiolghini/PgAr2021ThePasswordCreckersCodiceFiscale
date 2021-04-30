package it.unibs.fp.codicefiscale;


import javax.swing.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamConstants;



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

public class MainLettura {

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
					System.out.println("Inizio lettura file inputPersone" ); break;
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
		System.out.println(Comune.getCodiceComune("ISEO"));
		System.out.println(Comune.codiciComuni.get(8091));
		System.out.println(Comune.isValid(Comune.getCodiceComune("ISEO")));
	}
		
	}






