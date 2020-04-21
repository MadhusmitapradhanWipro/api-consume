package com.poc.apiconsume.apiconsume.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.poc.apiconsume.apiconsume.api.client.IRestClient;
import com.poc.apiconsume.apiconsume.dto.request.SampleRequestDTO;
import com.poc.apiconsume.apiconsume.dto.response.SampleResponseDTO;
import com.poc.apiconsume.apiconsume.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

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

}