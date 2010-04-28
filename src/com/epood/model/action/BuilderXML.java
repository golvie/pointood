/**
 * 
 */
package com.epood.model.action;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.epood.model.data.Order;
import com.epood.model.data.OrderItem;

/**
 * @author Jaroslav Judin
 * Apr 27, 2010
 */
public class BuilderXML {

	private static final String XML_VERSION = "1.0";
	private static final String XML_ENCODING = "UTF-8";
	private Node root = null;
	
	public BuilderXML() {
		
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Document generateDOM(Order order) {
		
		Element ord, products, product;
		Document xmlDoc = null;
	
		try {
	
	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			xmlDoc = docBuilder.newDocument();
				
			root = xmlDoc.createElement("order");
			xmlDoc.appendChild(root);
			
			ord = xmlDoc.createElement("order_id");
			root.appendChild(ord);
			ord.appendChild(xmlDoc.createTextNode(Integer.toString(order.getOrder())));
			
			ord = xmlDoc.createElement("date");
			root.appendChild(ord);
			ord.appendChild(xmlDoc.createTextNode(order.getCustomerConfirmed()));
			
			ord = xmlDoc.createElement("address");
			root.appendChild(ord);
			ord.appendChild(xmlDoc.createTextNode(order.getShippingAddress().getAddress()));
			
			ord = xmlDoc.createElement("total_price");
			root.appendChild(ord);
			ord.appendChild(xmlDoc.createTextNode(Double.toString(order.getOrderTotalPrice())));
			
			ord = xmlDoc.createElement("products");
			root.appendChild(ord);
			
			for (OrderItem orderItem : order.getOrderItems()){
				
				products = xmlDoc.createElement("product");
				ord.appendChild(products);
				
				product = xmlDoc.createElement("product_id");
				products.appendChild(product);
				product.appendChild(xmlDoc.createTextNode(Integer.toString(orderItem.getProductId())));
				
				product = xmlDoc.createElement("name");
				products.appendChild(product);
				product.appendChild(xmlDoc.createTextNode(orderItem.getProduct().getName()));
				
				product = xmlDoc.createElement("amount");
				products.appendChild(product);
				product.appendChild(xmlDoc.createTextNode(Integer.toString(orderItem.getItemCount())));
				
				product = xmlDoc.createElement("price");
				products.appendChild(product);
				product.appendChild(xmlDoc.createTextNode(Double.toString((orderItem.getItemCount() * orderItem.getProduct().getPrice()))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return xmlDoc ;
	}


	public String generateXMLString(Document document) {
	
		String xmlStr = null ;
			try {
			
				Source xmlSource = new DOMSource(document);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty("method", "xml");
				transformer.setOutputProperty("encoding", XML_ENCODING);
				transformer.setOutputProperty("indent", "yes");
				transformer.setOutputProperty("version", XML_VERSION);

				StringWriter sw = new StringWriter();
				StreamResult streamResult = new StreamResult(sw);
				
				transformer.transform(xmlSource, streamResult);
				xmlStr = sw.toString();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return xmlStr;
	}
	
	public static void main (String[] args) {
		BuilderXML build = new BuilderXML();
		Order order = new Order();
		order.setOrder(123);
		order.setCustomerConfirmed(new java.util.Date());
		String str = build.generateParsedXMLString(build.generateDOM(order));
		System.out.println(str);
	}
	
	public String generateParsedXMLString(Document document) {
		
		String xmlStr = null ;
			try {
				
				Source xmlSource = new DOMSource(document);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer(new javax.xml.transform.stream.StreamSource
			            ("www/xml/stylesheet.xsl"));
				transformer.setOutputProperty("method", "html");
				transformer.setOutputProperty("encoding", XML_ENCODING);
				transformer.setOutputProperty("indent", "yes");
				//transformer.setOutputProperty("version", XML_VERSION);
				
				StringWriter sw = new StringWriter();
				StreamResult streamResult = new StreamResult(sw);
				
				transformer.transform(xmlSource, streamResult);
				xmlStr = sw.toString();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return xmlStr;
	}
	
}
