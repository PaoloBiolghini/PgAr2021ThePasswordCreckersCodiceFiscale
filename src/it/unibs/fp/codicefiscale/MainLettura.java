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

		String nome = "", cognome = "", sesso = "", c = "", lastTag = "";

		Data da = null;

		Persona p = null;

		ArrayList<Persona> listaPersone = new ArrayList<>();
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;

		try {

			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));

		} catch (Exception e) {
			System.out.println("Errore inizializzazione del reader:");
			System.out.println(e.getMessage());
		}
		while (xmlr.hasNext()) {
			switch (xmlr.getEventType()) {
			case XMLStreamConstants.START_DOCUMENT: // leggere cosa fa
				System.out.println("Inizio lettura file inputPerosne");
				break;
			case XMLStreamConstants.START_ELEMENT:
				lastTag = xmlr.getLocalName();

				System.out.println("Tag " + xmlr.getLocalName());
				for (int i = 0; i < xmlr.getAttributeCount(); i++)
					System.out.printf(" -> attributo %s->%s%n", xmlr.getAttributeLocalName(i),
							xmlr.getAttributeValue(i));
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (xmlr.getLocalName().equalsIgnoreCase("persona")) {
					p = new Persona(nome, cognome, sesso, c, da);
					listaPersone.add(p);
					System.out.println(listaPersone.get(0).getCodiceFiscale());
				}
				System.out.println("end-tag: " + xmlr.getLocalName());
				break;
			case XMLStreamConstants.COMMENT:
				System.out.println("commento " + xmlr.getText());
				break;
			case XMLStreamConstants.CHARACTERS:
				switch (lastTag.toLowerCase()) {
				case "nome":
					nome = xmlr.getText().trim();
					lastTag = "";
					System.out.println(nome);
					break;
				case "cognome":
					cognome = xmlr.getText().trim();
					lastTag = "";
					System.out.println(cognome);
					break;
				case "sesso":
					sesso = xmlr.getText().trim();
					lastTag = "";

					break;
				case "comune_nascita":
					c = xmlr.getText();
					lastTag = "";

					break;
				case "data_nascita":
					da = Data.estraiData(xmlr.getText().trim());
					lastTag = "";

					break;

				}
				if (xmlr.getText().trim().length() > 0)
					System.out.println("->    " + xmlr.getText());

				break;
			}

			xmlr.next();
		}
		MainScrittura.creaxml(listaPersone);
	}
}
