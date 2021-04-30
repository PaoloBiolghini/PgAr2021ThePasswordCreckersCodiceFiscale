package it.unibs.fp.codicefiscale;

import java.io.FileOutputStream;
import java.util.ArrayList;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class MainScrittura {

	private static ArrayList<String> codiciCorretti;
	private static ArrayList<String> codiciSbagliati;
	
	
	
	
	
	public static XMLStreamWriter getDocument() throws XMLStreamException
	{
		
		String filename="Scrittura.xml";
		
		
		XMLOutputFactory xmlof = null; 
		XMLStreamWriter xmlw = null; 
		try { 
		 xmlof = XMLOutputFactory.newInstance(); 
		 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filename), "utf-8"); 
		 xmlw.writeStartDocument("utf-8", "1.0"); 
		 
		} 
		
		catch (Exception e) { 
		 System.out.println("Errore nell'inizializzazione del writer:"); 
		 System.out.println(e.getMessage()); 
		 
		} 
		
		return xmlw;
		
	}
	

		
		
	
	
	public static void creaxml(ArrayList<Persona> listaPersone) throws XMLStreamException
	{
		XMLStreamWriter xmlw = getDocument(); 
		
		ArrayList<String> codiciCorretti=LetturaCodici.letturaCodicixml(true);
		ArrayList<String> codiciSbagliati=LetturaCodici.letturaCodicixml(false);
		
		try { 
			
		 xmlw.writeStartElement("output"); 
		 int size=listaPersone.size();
		 
		 //sezione persone
		 xmlw.writeStartElement("persone"); 
		 xmlw.writeAttribute("numero", Integer.toString(listaPersone.size())); 
		 for (int i = 0; i <size ; i++) { 
			 String nome=listaPersone.get(i).getNome();
			 String cognome=listaPersone.get(i).getCognome();
			 String comune=listaPersone.get(i).getCognome();
			 String dataNascita= listaPersone.get(i).getCompleanno();
			 String sesso=listaPersone.get(i).getSesso();
			 StringBuffer codiceFiscale=listaPersone.get(i).getCodiceFiscale();
			 		 
		 xmlw.writeStartElement("Persona"); 
		 xmlw.writeAttribute("id", Integer.toString(i)); 
		 
		 xmlw.writeStartElement("nome");
		 xmlw.writeCharacters(nome); 
		 xmlw.writeEndElement();
		 
		 xmlw.writeStartElement("cognome");
		 xmlw.writeCharacters(cognome); 
		 xmlw.writeEndElement();
		 
		 xmlw.writeStartElement("datadinascita");
		 xmlw.writeCharacters(dataNascita); 
		 xmlw.writeEndElement();
		 
		 xmlw.writeStartElement("comune");
		 xmlw.writeCharacters(comune); 
		 xmlw.writeEndElement();
		 
		 xmlw.writeStartElement("sesso");
		 xmlw.writeCharacters(sesso); 
		 xmlw.writeEndElement();
		 		 
		 xmlw.writeStartElement("codicesifcale");
		 xmlw.writeCharacters(controlloCodici(codiceFiscale)); 
		 xmlw.writeEndElement();
		  
		 xmlw.writeEndElement(); 
		 } 
		 xmlw.writeEndElement(); 
		 
		 //sezione codici
		 xmlw.writeStartElement("codici"); 
		 
		 //codici sbagliati
		 xmlw.writeStartElement("invalidi"); 
		 xmlw.writeAttribute("numero", Integer.toString(codiciSbagliati.size()));	 
		 for(int i=0;i<codiciSbagliati.size();i++)
		 {
			 xmlw.writeStartElement("codice"); 
			 xmlw.writeAttribute("id", Integer.toString(i));
			 xmlw.writeCharacters(codiciSbagliati.get(i)); 
			 xmlw.writeEndElement();
		 }
		 
		 xmlw.writeEndElement();
		 //codici spaiati
		 xmlw.writeStartElement("spaiati"); 
		 xmlw.writeAttribute("numero", Integer.toString(codiciCorretti.size()));
		 for(int i=0;i<codiciCorretti.size();i++)
		 {
			 xmlw.writeStartElement("codice"); 
			 xmlw.writeAttribute("id", Integer.toString(i));
			 xmlw.writeCharacters(codiciCorretti.get(i)); 
			 xmlw.writeEndElement();
		 }
		 xmlw.writeEndElement();
		 
		 xmlw.writeEndElement();
		 xmlw.writeEndElement();
		 
		 
		 xmlw.writeEndDocument();
		 xmlw.flush(); 
		 xmlw.close(); 
		 System.out.println("lunghezza="+codiciCorretti.size());
		 } 
		
		catch (Exception e) { 
			 System.out.println("Errore nella scrittura"); 
		} 
	}
	
	
	
	public static String controlloCodici(StringBuffer codiceFiscale)
	{
		if(!codiciCorretti.contains(codiceFiscale))
		{
			return "ASSENTE";
		}
		
		codiciCorretti.remove(codiceFiscale);
		return codiceFiscale;
	}

}
