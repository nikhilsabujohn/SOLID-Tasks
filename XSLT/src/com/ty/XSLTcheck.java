package com.ty;
import com.ty.*;

	import javax.xml.transform.Source;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.stream.StreamResult;
	import javax.xml.transform.stream.StreamSource;

	public class XSLTcheck {
	    public static void main(String[] args) {
	        try {

	            Source xmlSource = new StreamSource("src/check.xml");
	            Source xsltSource = new StreamSource("src/XSL.xsl");


	            TransformerFactory transformerFactory = TransformerFactory.newInstance();


	            Transformer transformer = transformerFactory.newTransformer(xsltSource);
	            StreamResult result = new StreamResult("src/FINAL.html");
	            transformer.transform(xmlSource, result);

	            System.out.println("XSLT transformation completed successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


