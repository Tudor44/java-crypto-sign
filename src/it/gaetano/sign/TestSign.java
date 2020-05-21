package it.gaetano.sign;

import java.io.File;
import java.io.FileNotFoundException;

import org.w3c.dom.NodeList;

public class TestSign {

    public static void main(String arg[]) {

        File fileDocument = new File(arg[0]);
        try {
            NodeList signatureNode = XmlVerifySignature.findSignatureFromXml(fileDocument.getAbsolutePath());
            if(signatureNode!=null)
                System.out.println("The document :"+fileDocument.getName() +" is signed");
                //TODO check if the signature is valid
            else
                System.out.println("The document :"+fileDocument.getName() +" is unsigned");
        }
        catch (FileNotFoundException e){
            System.out.println("The input document is not found");
        }
        catch (Exception e){
            System.out.println("Generic Exception, probably format is invalid");
        }

    }

}
