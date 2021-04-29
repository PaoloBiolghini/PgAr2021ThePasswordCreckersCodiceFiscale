package it.unibs.fp.codicefiscale;

public class MainScrittura {

	package it.unibs.fp.scritturaxml;

	import java.io.FileOutputStream;
	import java.util.ArrayList;


	import javax.xml.stream.XMLOutputFactory;
	import javax.xml.stream.XMLStreamWriter;

	public class MainScrittura {

		public static void main(String[] args) {
			
			ArrayList <String> prova=new ArrayList();
			prova.add("ciao");
			prova.add("paolo");
			scritturaxml(prova);		

		}
		
		public static XMLStreamWriter sartDocument()
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
		
		public static void scritturaxml(ArrayList<String> listacodici)
		{
			XMLStreamWriter xmlw = sartDocument(); 
			
			
			
			
			try { 
			 xmlw.writeStartElement("output"); 
			
			 for (int i = 0; i < listacodici.size(); i++) { 
			 xmlw.writeStartElement("Persona"); 
			 xmlw.writeAttribute("id", Integer.toString(i)); 
			 
			 xmlw.writeStartElement("codicesifcale");
			 xmlw.writeCharacters(listacodici.get(i));  
			 xmlw.writeEndElement();
			 
			 xmlw.writeStartElement("trovato");
			 xmlw.writeCharacters("Trovato");
			 xmlw.writeEndElement();
			 
			 xmlw.writeEndElement(); 
			 } 
			 xmlw.writeEndElement(); 
			 xmlw.writeEndDocument();
			 xmlw.flush(); 
			 xmlw.close(); 
			 } 
			
			catch (Exception e) { 
				 System.out.println("Errore nella scrittura"); 
			} 
		}
		
		public static String controlloCodici()
		{
			return "Corretto";
		}

	}

	
	

}
