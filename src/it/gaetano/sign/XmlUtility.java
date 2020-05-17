package it.gaetano.sign;

import java.io.*;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/*
 * Gaetano 
 * Xml utility class 
 */
public class XmlUtility {

	protected static Document getXmlDocument(String xmlFilePath) throws Exception,FileNotFoundException {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setIgnoringComments(true);
		return dbf.newDocumentBuilder().parse(new FileInputStream(xmlFilePath));
	}

	public static String decodeXmlFromBase64(String base64) {
		return new String(Base64.getMimeDecoder().decode(base64.getBytes()));
	}

	public static String encodeXmlFromBase64(String xml) {
		return Base64.getEncoder().encodeToString(xml.getBytes());
	}


}