package com.qa.convert;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

 

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

 

public class XMLParsing {
    
    public static void main(String[] args) throws Throwable {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.newDocumentBuilder();
        try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc =  builder.parse("C:\\Users\\Manisha\\Desktop\\ShareScreen\\com.qa.demo\\test-output\\testng-results.xml");
        NodeList testngres = doc.getElementsByTagName("testng-results");
        for(int i=0; i<testngres.getLength();i++)
        {
            Node p = testngres.item(i);
            if(p.getNodeType()==Node.ELEMENT_NODE);
            Element testng = (Element) p;
            String skipped =  testng.getAttribute("skipped");
            String failed = testng.getAttribute("failed");
            String total = testng.getAttribute("total");
            String passed = testng.getAttribute("passed");
            NodeList list = testng.getChildNodes();
            for(int j=0;j<list.getLength();j++)
            {
                Node n = list.item(j);
                    if(n.getNodeType()==Node.ELEMENT_NODE)
                    {
                        Element name = (Element) n;
                        
                    }
                    
            }
            System.out.println("Skipped = " + skipped);
            System.out.println("failed = " + failed);
            System.out.println("total = " + total);
            System.out.println("passed = " + passed);
        }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}