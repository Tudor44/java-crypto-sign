package it.gaetano.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class CryptoUtility {
	
	private static CryptoUtility cryptoUtility;
	KeyPairGenerator kpg;
	private KeyPair kp; 
	
	private CryptoUtility() {
		
	}
	
	protected KeyPair getOrGenerateKeyPair(int length, String algorithm) throws NoSuchAlgorithmException {
		if(this.kpg==null) {
			SecureRandom rand = new SecureRandom();
			kpg = KeyPairGenerator.getInstance(algorithm);
			kpg.initialize(length, rand);
			this.kp = kpg.generateKeyPair();
		}
		else
			this.kp = this.getKeyPair();
		return kp;
	}
	
	private KeyPair getKeyPair() {
		return this.kp; 
	}
	
	protected PublicKey getPublicKey() {
		return kp.getPublic();
	}
	
	protected PrivateKey getPrivateKey() {
		return kp.getPrivate();
	}
	
	public static synchronized CryptoUtility getInstance( ) {
		if (cryptoUtility == null)
			cryptoUtility = new CryptoUtility();
		return cryptoUtility;
	}
	
	public byte[] signFile(PrivateKey privateKey,File inputFile) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, IOException {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		InputStream in = null;
		
		try {
		    in = new FileInputStream(inputFile);
		    byte[] buf = new byte[2048];
		    int len;
		    while ((len = in.read(buf)) != -1) {
		    	signature.update(buf, 0, len);
		    }
		} 
		finally {
		    if ( in != null ) in.close();
		}
		
		return signature.sign();
		
	}
	
	public void verifyFile(PublicKey publicKey, File inputFile, byte[] signInBytes) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		InputStream in = null;
		try {
		    in = new FileInputStream(inputFile);
		    byte[] buf = new byte[2048];
		    int len;
		    while ((len = in.read(buf)) != -1) {
		    	signature.update(buf, 0, len);
		    }
		} 
		finally {
		    if ( in != null ) in.close();
		}
		System.out.println("The signature of file: "+inputFile.getName() + (signature.verify(signInBytes) ? " is valid" : " is invalid"));

	}
	
	
	
}