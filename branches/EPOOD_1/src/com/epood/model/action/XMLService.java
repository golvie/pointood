package com.epood.model.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.epood.model.dao.OrderDao;
import com.epood.model.data.Order;

@SuppressWarnings("serial")
public class XMLService extends HttpServlet {

	
	Logger log = Logger.getLogger(this.getClass());

	public  void init() {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
             PrintWriter out = response.getWriter();

               int orderId = Integer.valueOf(request.getParameter("order"));
               if (orderId != 0) {
                	Order order = new OrderDao().getOrder(orderId);
                	log.info("OrderXMLNumDoGet "+orderId+" "+order.getOrderNumber());
                	BuilderXML builder = new BuilderXML();
                	Document xml = builder.generateDOM(order);
	                response.setContentType("text/xml");
	                //out.print(generateXMLString(xml)) ;
	                if(request.getParameter("parse")!=null){
	                    try
	                    {
	                    	Node pi = xml.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"xml/stylesheet.xsl\"");
	                        xml.insertBefore(pi, builder.getRoot());
	                        String str = builder.generateXMLString(xml);
	                        if (str != null)
	                        	out.print(str);
	                        else
	                        	out.print("nothing");
	                    }
	                    catch (Exception e) {}
	                }else{
	                	out.print(builder.generateXMLString(xml)) ;
	                }
               }
               
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		doGet(request, response);
	}



	

	public String getServletInfo() {
		return "Order application servlet";
	}
}