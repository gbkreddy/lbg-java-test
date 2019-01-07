package com.lbg;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.lbg.exception.InvalidXMLException;
import com.lbg.exception.XMLNotFoundException;

public class PersonsXMLParser {
	public static void main(String[] args) throws XMLNotFoundException, InvalidXMLException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc;
		try {
			builder = factory.newDocumentBuilder();
			if (args.length == 0) {
				doc = builder.parse("persons.xml");
			} else
				doc = builder.parse(args[0]);

			XPathFactory xpathfactory = XPathFactory.newInstance();
			XPath xpath = xpathfactory.newXPath();

			System.out.println("// Get persons whose last-name is Kumar ");

			XPathExpression expr = xpath.compile("//person[contains(last-name,'Kumar')]");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getChildNodes().item(1).getTextContent());
			}

			System.out.println("// Get persons whose first-name is Pramod ");

			expr = xpath.compile("//person[contains(first-name,'Pramod')]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getChildNodes().item(1).getTextContent());
			}
		} catch (ParserConfigurationException e) {
			LoggerFactory.getLogger(PersonsXMLParser.class).error("ParserConfigurationException", e);
		} catch (SAXException e) {
			LoggerFactory.getLogger(PersonsXMLParser.class).error("Invalid XML", e);
			throw new InvalidXMLException("Invalid XML");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new XMLNotFoundException("");
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
