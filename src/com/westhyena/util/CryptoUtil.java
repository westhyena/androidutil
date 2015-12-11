package com.westhyena.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {

	public static String GetMD5HashString(String input) {
		return GetMD5Hash(input.getBytes());
	}
	public static String GetMD5Hash(byte[] input) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(input);
			byte[] byteData = md5.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; ++i) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
}
