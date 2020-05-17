package it.gaetano.sign;

import java.security.PublicKey;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
 * Gaetano
 * Xml Verify class
 */
public class XmlVerifySignature {

    public static boolean isValidXmlSignature(NodeList nodeSignature,
                                                   PublicKey publicKey) throws Exception {
        DOMValidateContext valContext = new DOMValidateContext(publicKey, nodeSignature.item(0));
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
        XMLSignature signature = fac.unmarshalXMLSignature(valContext);
        return signature.validate(valContext);
    }

    public static NodeList findSignatureFromXml(String xmlToCheck) throws Exception {
        Document doc = XmlUtility.getXmlDocument(xmlToCheck);
        NodeList nodeSignature = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
        return nodeSignature.getLength() == 0 ? null : nodeSignature;
    }
}
