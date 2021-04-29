package it.unibs.fp.codicefiscale;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class LetturaCodici {

	private static String NOMEFILE="codiciFiscali.xml";
	
	public static void main(String[] args) throws XMLStreamException {
		
		letturaCodicixml();
	}
	
	public static XMLStreamReader creazioneReader()
	{
		XMLInputFactory xmlif=null;
		XMLStreamReader xmlr=null;

		try{
			xmlif=XMLInputFactory.newInstance();
			xmlr=xmlif.createXMLStreamReader("inputPersone.xml",new FileInputStream(NOMEFILE));
		}
		
		catch (Exception e){
			System.out.println("Errore inizializzazione del reader:");
			System.out.println(e.getMessage());
		}
		return xmlr;
	}
	
	public static ArrayList<String> letturaCodicixml() throws XMLStreamException 
	{		
		XMLStreamReader xmlr=creazioneReader();
		ArrayList<String> codiciValidi=new ArrayList();
		String cod=null;
		
		try {
			while(xmlr.hasNext()){
				switch (xmlr.getEventType()){
		
					case  XMLStreamConstants.END_ELEMENT:
						
						if(xmlr.getLocalName().equals("codice"))
						{
							
							if(ControlloCodiceFiscale.controllaCodice(cod)) {
								codiciValidi.add(cod);		
							}
							else {
								//System.out.println(cod+" non è valido");
							}
							
						}
						break;
						
					case XMLStreamConstants.CHARACTERS:
						if(xmlr.getText().trim().length() >0)
							cod=xmlr.getText();
							
						break;
				}
				xmlr.next();
			}
		} 
		
		catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		return codiciValidi;
		
	}
	
	
	
	

}
