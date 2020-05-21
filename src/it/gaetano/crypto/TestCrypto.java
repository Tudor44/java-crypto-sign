package it.gaetano.crypto;

import java.security.NoSuchAlgorithmException;

public class TestCrypto {
	
    public static void main(String arg[]) throws NoSuchAlgorithmException {
    	
    	CryptoUtility cp = CryptoUtility.getInstance();
    	cp.getOrGenerateKeyPair(1024,"RSA");
    	System.out.println(cp.getPublicKey());
    	System.out.println(cp.getPrivateKey());
    	
    }

}
