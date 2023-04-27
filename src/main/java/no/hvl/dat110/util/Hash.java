package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			
			// we use MD5 with 128 bits digest
			
			// compute the hash of the input 'entity'
			byte[] entityBytes = md.digest(entity.getBytes());
			// convert the hash into hex format
			String hex = toHex(entityBytes);
			// convert the hex into BigInteger
			hashint = new BigInteger(hex, 16); 
			// return the BigInteger
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		BigInteger bi = new BigInteger("2");
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return bi.pow(bitSize());
	}
	
	public static int bitSize(){
		
		int digestlen = 0;
		
		MessageDigest message = null;
		try {
			message = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		digestlen = message.getDigestLength();
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
