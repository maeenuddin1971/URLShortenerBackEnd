package com.urlshort.timyurl.UrlShortener.utils;

import java.util.Random;

public class UrlConvertor {
	
    private Boolean checkInDatabase =Boolean.FALSE;

	public String randomStringGenerator() {

		Random rt = new Random();
		String randomString = "";

		String allAlphabet = "MNBVCXZLKJHGFDSAPOIUYTREWQmnbvcxzlkjhgfdsapoiuytrewq1234567890";

		for (int i = 0; i < 5; i++) {
			randomString = randomString + allAlphabet.charAt(rt.nextInt(allAlphabet.length()));
		}
		

		return randomString;
	}
	
	public String checkIfHttp(String url) {
		
		if(url.substring(0, 8).contains("https://")) {
			return url.substring(8, url.length());
		}
		else if(url.substring(0, 7).contains("http://")) {
			return url.substring(7, url.length());
		}
		else {
			return url;
		}
	}

}
