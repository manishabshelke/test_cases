package com.qa.convert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Dictionary;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.reporters.XMLConstants;
import org.w3c.dom.Document;

//public class xmlfileToJsonfile {

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class ReadXmlDomParser {

	private static final String FILENAME = "C:\\Users\\Manisha\\Desktop\\ShareScreen\\com.qa.demo\\test-output\\testng-results.xml";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// parse XML file
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(new File(FILENAME));

		doc.getDocumentElement().normalize();

		System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(" \n" + "Total : " + doc.getDocumentElement().getAttribute("total"));
		sb.append("\n" + "Passed : " + doc.getDocumentElement().getAttribute("passed"));
		sb.append("\n" + "Failed : " + doc.getDocumentElement().getAttribute("failed"));
		sb.append("\n" + "Skipped : " + doc.getDocumentElement().getAttribute("skipped"));

		NodeList suitedura = doc.getElementsByTagName("suite");

		for (int j = 0; j < suitedura.getLength(); j++) {
			Node mNode = suitedura.item(j);

			if (mNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) mNode;
				String totleDuration = eElement.getAttribute("duration-ms");
				long l = Long.parseLong(totleDuration);

				long seconds = TimeUnit.MILLISECONDS.toSeconds(l);
				sb.append("\n" + "TotleDuration-sec : " + seconds);
				
				sb.append("\n" + "}");


			}

			System.out.println(sb);

			int count = 1;
			NodeList nList = doc.getElementsByTagName("test-method");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Test :" + nNode.getNodeName() + count);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					System.out.println("{");
					System.out.println("Test Name : " + eElement.getAttribute("name"));

					String dur = eElement.getAttribute("duration-ms");

					long l = Long.parseLong(dur);

					long seconds = TimeUnit.MILLISECONDS.toSeconds(l);
					System.out.println("Test Duration-sec : " + seconds);

					System.out.println("TestStatus : " + eElement.getAttribute("status"));
					count++;
					
					System.out.println("}");

				}

			}
		}
		
		sb.append("\n" + "}");
	}

}

/*
 * public static int PRETTY_PRINT_INDENT_FACTOR = 4;
 * 
 * public static void main(String[] args) throws IOException {
 * 
 * File xmlfile= new File(
 * "C:\\Users\\Manisha\\Desktop\\ShareScreen\\com.qa.demo\\TestCaseResult.xml");
 * 
 * byte[] b=Files.readAllBytes(xmlfile.toPath());
 * 
 * String xml=new String(b);
 * 
 * JSONObject obj=XML.toJSONObject(xml); String jsonPrettyPrintString =
 * obj.toString(PRETTY_PRINT_INDENT_FACTOR);
 * System.out.println(jsonPrettyPrintString);
 * 
 * //System.out.println(obj);
 * 
 * }
 */
