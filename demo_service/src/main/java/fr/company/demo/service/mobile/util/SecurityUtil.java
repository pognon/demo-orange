package fr.company.demo.service.mobile.util;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SecurityUtil {

	private static final Logger logger = Logger.getLogger(SecurityUtil.class
			.getName());

	public static boolean isAuthenticatedUser(String username,
			String timestamp, String hash) {
		if (username.equals(SystemProperties.getWSCallerId())
				&& isValidSignature(SystemProperties.getWSCallerSecret(),
						timestamp, hash)) {
			return true;
		}
		return false;
	}

	public static boolean isValidSignature(String secret, String timestamp,
			String senderHash) {
		String computedHash = new String(Hex.encodeHex(DigestUtils.sha(secret
				+ timestamp)));
		if (computedHash.equals(senderHash))
			return true;
		return false;
	}

	public static String encrypt(String plainText) {
		try {
			final SecretKey skey = buildSecretKey(SystemProperties
					.getWSCallCryptKey());

			final Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skey);

			final int taille = plainText.getBytes("UTF-8").length;
			final byte[] encryptedBytes = cipher.doFinal(plainText
					.getBytes("UTF-8"), 0, taille);

			return Base64.encodeBase64URLSafeString(encryptedBytes);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String cipherText) {

		try {
			final SecretKey skey = buildSecretKey(SystemProperties
					.getWSCallCryptKey());

			// dÈcodage de la String en base64 vers un byte[]
			final byte[] decodedBytes = Base64.decodeBase64(cipherText);

			// Decryptage de la chaine
			final Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			final byte[] decryptedBytes = cipher.doFinal(decodedBytes);

			return new String(decryptedBytes, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static SecretKey buildSecretKey(String strSecretKey)
			throws IOException {
		// On recrÈe la clÈ de cryptage - passephrase

		final byte[] keyBytes = Base64.decodeBase64(strSecretKey);

		final SecretKey skey = new SecretKeySpec(keyBytes, "AES");

		return skey;
	}

	
	public static String generateKey() {
		try {

			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom random = new SecureRandom();
			keygen.init(random);
			SecretKey key = keygen.generateKey();

			return Base64.encodeBase64String(key.getEncoded());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Le token est envoyé par le client dans le header sous la forme
	// Authorization : Encrypted(hash:xxxxxxx username:xxxxxxx password:xxxxxxx)
	public static boolean isValidToken(String token) {

		final String DELIMITER = " ";
		final String SECOND_DELIMITER = ":";

		String decryptedToken = decrypt(token.trim());
		
		logger.info("isValidToken with data : " + decryptedToken);

		StringTokenizer st = new StringTokenizer(decryptedToken, DELIMITER);
		String currentToken = null;
		String hash = null;
		String username = null;
		String password = null;
		while (st.hasMoreTokens()) {
			currentToken = st.nextToken();
			
			logger.info("The current token is : " + currentToken);
			
			StringTokenizer t = new StringTokenizer(currentToken, SECOND_DELIMITER);
			String key = null;
			
			while(t.hasMoreTokens()){
					key = t.nextToken();
					
					if (key.trim().equals("hash"))
						hash = t.nextToken();
					if (key.trim().equals("username"))
						username = t.nextToken();
					if (key.trim().equals("password"))
						password = t.nextToken();
			}
			
		}

		String computedHash = new String(Hex.encodeHex(DigestUtils.sha(username
				+ password)));

		if (hash.equals(computedHash))
			return true;

		return false;

	}

	public static String generateToken(String username, String password) {

		String computedHash = new String(Hex.encodeHex(DigestUtils.sha(username
				+ password)));
		String plainText = "hash:" + computedHash + " username:" + username
				+ " password:" + password;

		return encrypt(plainText);

	}

	public static boolean isValidAuthorizationHeaders(List<String> headers) {
		
		
		if (SystemProperties.isSessionTokenCheckEnabled()) {

			if (headers == null)
				return false;

			else {
				
				logger.info("The received headers : " + headers.toString());

				String authorizationHeaderData = headers.get(0);
				
				logger.info("isValidAuthorizationHeaders with data : " + authorizationHeaderData );
				
				if (StringUtils.isEmpty(authorizationHeaderData))
					return false;
				else {
					return isValidToken(authorizationHeaderData);
				}
			}

		}

		return true;
	}
	
	public static boolean resetToken(List<String> headers){
		
		if(isValidAuthorizationHeaders(headers)){
			generateToken("", "");  // Pour le moment on reinitialise.
			
			return true;
		}
		
		
		return false;
		
	}

}
