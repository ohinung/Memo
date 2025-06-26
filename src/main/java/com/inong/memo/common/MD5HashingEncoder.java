package com.inong.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingEncoder {
	
	//문자열을 MD5로 해슁~~
	//원본 데이터를 다른 형태로 바꾼다 : 인코딩
	//객체 생성 없이 활용할 수 있다.**
	public static String encode(String message) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			byte[] bytes = message.getBytes();
			messageDigest.update(bytes);
			//byte 연산
			byte[] digest = messageDigest.digest();
			
			String result ="";
			for(int i = 0; i < digest.length;i++  ) {
				result += Integer.toHexString(digest[i] & 0xff);
			}
			return result;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	}

}
