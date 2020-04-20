package com.poc.apiconsume.apiconsume.service;

import java.net.URI;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.poc.apiconsume.apiconsume.api.client.IRestClient;
import com.poc.apiconsume.apiconsume.dto.request.SampleRequestDTO;
import com.poc.apiconsume.apiconsume.dto.response.SampleResponseDTO;

@Service
public class SampleServiceImpl {

	@Autowired
	private IRestClient client;

	public SampleResponseDTO sampleFetchAPIMethod(SampleRequestDTO serviceRequestBody) throws Exception {
		final String serviceUrl = new StringBuilder().append("https://reqres.in/api/users").toString();

		RequestEntity<SampleRequestDTO> entity = new RequestEntity<SampleRequestDTO>(serviceRequestBody,
				HttpMethod.POST, new URI(serviceUrl));
		/*
		 * Map<String, Object> paramList = new HashMap<>(); paramList.put("name",
		 * "Madhusmita"); paramList.put("movies",
		 * "[\"Rockstar Man\", \"Role Models\"]");
		 */
		SampleResponseDTO serviceResponseBody = client.invokePOST(serviceUrl, entity, SampleResponseDTO.class);
		return serviceResponseBody;
	}

	/**
	 * For Authorization header, can be moved to Utility Class
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unused")
	private HttpHeaders createHttpHeaders(String user, String password)
	{
	    String notEncoded = user + ":" + password;
	    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", encodedAuth);
	    return headers;
	}

}