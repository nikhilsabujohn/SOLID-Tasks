package com.ty;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xpath {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/book.xml");

            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();

            String expression = "/bookstore/book";
            NodeList nodeList = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node book = nodeList.item(i);
                NodeList childNodes = book.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) 
                {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(childNode.getNodeName() + ": " + childNode.getTextContent());
                    }
                }
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


