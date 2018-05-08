package com.epam.mentoring.module06.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Module 06 - XML");

        System.out.println("SAX Parser");

        File xmlFile = new File("data\\books.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFile, new SAXParserExample());

        System.out.println();
        System.out.println("DOM Parser");

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
        Document doc = domBuilder.parse(xmlFile);

        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList children = doc.getElementsByTagName("book");
        for (int i = 0; i < children.getLength(); ++i) {
            Node curChild = children.item(i);
            System.out.println(curChild.getNodeName());
            System.out.println(curChild.getAttributes().getNamedItem("id"));

            if (curChild.getNodeType() == Node.ELEMENT_NODE) {
                Element curElement = (Element) curChild;
                System.out.println("Book id = " + curElement.getAttribute("id"));

                System.out.println("Author " +
                        curElement.getElementsByTagName("author").item(0).getTextContent());
            }
        }
    }
}

class SAXParserExample extends DefaultHandler {
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Tag " + qName);

        if (qName.equals("book")) {
            System.out.println("Book Id " + attributes.getValue("id"));
            System.out.println("Amount of pages " + attributes.getValue("pages"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length).trim();

        if (text.length() > 0)
            System.out.println(text);
    }
}