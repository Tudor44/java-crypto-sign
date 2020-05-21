package it.gaetano.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class CryptoUtility {
	
	private static CryptoUtility cryptoUtility;
	KeyPairGenerator kpg;
	private KeyPair kp; 
	
	private CryptoUtility() {
		
	}
	
	protected KeyPair getOrGenerateKeyPair(int length, String algorithm) throws NoSuchAlgorithmException {
		if(this.kpg==null) {
			kpg = KeyPairGenerator.getInstance(algorithm);
			kpg.initialize(length);
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
	
}