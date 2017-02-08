package fr.pizzeria.spring.web.resource.auth;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClientAuth {
	
	private final Logger log = LoggerFactory.getLogger(ClientAuth.class);
	
	private static final String CIPHER_ALGORITHM	= "AES";
	private static final String KEY_ALGORITHM		= "AES";
	private static final byte[] SECRET_KEY			= "16BYTESSECRETKEY" .getBytes(StandardCharsets.UTF_8);
	
	public String encrypt(String email) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SECRET_KEY, KEY_ALGORITHM));
			String code = email + "&" + String.valueOf(new Date().getTime());
			return Base64.encodeBase64URLSafeString(cipher.doFinal(code.getBytes(StandardCharsets.UTF_8)));
		} catch(Exception e) {
			log.warn(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public String decrypt(String encrypt) {
		try {
			System.out.println("Token : " + encrypt);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY, KEY_ALGORITHM));
			String decryptedToken = new String(cipher.doFinal(Base64.decodeBase64(encrypt)), StandardCharsets.UTF_8);
			System.out.println("Token after decrypt : " + decryptedToken);
			return decryptedToken;
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
			throw new RuntimeException();
		}
	}

	public void print() {
	    System.out.println("bite");
    }
}
