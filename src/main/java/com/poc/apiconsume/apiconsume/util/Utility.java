package com.poc.apiconsume.apiconsume.util;

import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Utility {
	/**
	 * For Authorization header, can be moved to Utility Class
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public static HttpHeaders createAuthorizationHttpHeader(String user, String password) {
		String notEncoded = user + ":" + password;
		String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", encodedAuth);
		return headers;
	}

}
