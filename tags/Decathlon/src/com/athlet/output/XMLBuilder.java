/**
 * 
 */
package com.athlet.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.athlet.domain.Result;
import com.athlet.domain.Sportsman;

/**
 * @author Jaroslav Judin
 * May 27, 2010
 */
public class XMLBuilder {

	private static final String XML_VERSION = "1.0";
	private static final String XML_ENCODING = "UTF-8";
	private ArrayList<Sportsman> men;
	
	public XMLBuilder(ArrayList<Sportsman> men) {
		 this.men = men;
		 writeXML(constructXML(), false);
		 writeXML(constructXML(), true);
	}
	
	public Document constructXML() {
		
		Document doc = null;
		Element root, sportsman, name, place, totalscore, part, event, point;
		try {
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			doc = docBuilder.newDocument();
			
			
            //Creating the XML tree

            //create the root element and add it to the document
            root = doc.createElement("decathlon");
            doc.appendChild(root);

            //create a comment and put it in the root element
            //Comment comment = doc.createComment("Just a thought");
            //root.appendChild(comment);
            
            for (Sportsman man : men) {
            
	            //create child element, add an attribute, and add to root
	            sportsman = doc.createElement("sportsman");
	            //sportsman.setAttribute("name", "value");
	            //root.appendChild(sportsman);
	            name = doc.createElement("name");
	            name.appendChild(doc.createTextNode(man.getName()));
	            sportsman.appendChild(name);
	            
	            place = doc.createElement("place");
	            place.appendChild(doc.createTextNode(man.getPlace()));
	            sportsman.appendChild(place);
	            
	            totalscore = doc.createElement("totalscore");
	            totalscore.appendChild(doc.createTextNode( man.getTotalScore()+""));
	            sportsman.appendChild(totalscore);
	            
	            part = doc.createElement("participation");
	            
	            for (Result res : man.getResults()) {
	            	event = doc.createElement("event");
	            	event.setAttribute("name", res.getName());
	            	
	            	point = doc.createElement("points");
	            	
	            	if (res.getMeters()>0) {
	            		point.appendChild(doc.createTextNode( res.getMeters()+""));
	            		point.setAttribute("unit", "meters");
	            	} else {
	            		point.appendChild(doc.createTextNode( res.getSec()+""));
	            		point.setAttribute("unit", "seconds");
	            	}
	            	event.appendChild(point);
	            	part.appendChild(event);
	            }
	            sportsman.appendChild(part);
	            
	            root.appendChild(sportsman);
            
            }
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public void writeXML(Document doc, boolean isXSL) {
		//Output the XML
		String outputFile = null;
		Transformer trans = null;
        try {
			//set up a transformer
			TransformerFactory transfac = TransformerFactory.newInstance();
			if (!isXSL) {
				trans = transfac.newTransformer(); //new StreamSource("styles.xsl")
				outputFile = "outputData.xml";
			} else {
				trans = transfac.newTransformer(new StreamSource("styles.xsl"));
				outputFile = "outputData.htm";
			}
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.METHOD, "xml");
			trans.setOutputProperty(OutputKeys.ENCODING, XML_ENCODING);
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			trans.setOutputProperty(OutputKeys.VERSION, XML_VERSION);

			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			trans.transform(source, new StreamResult(new FileOutputStream(outputFile)) );
			String xmlString = sw.toString();
			//print xml
			if (!isXSL)
				System.out.println("Here's the xml:\n\n" + xmlString);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
}
