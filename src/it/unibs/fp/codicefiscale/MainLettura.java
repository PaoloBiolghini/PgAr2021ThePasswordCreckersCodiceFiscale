package it.unibs.fp.codicefiscale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MainLettura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder=factory.newDocumentBuilder();
			Document doc=Builder.parse("Persone.xml");
			
			NodeList list=doc.getElementsByTagName("persona");
			
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
	}

}
