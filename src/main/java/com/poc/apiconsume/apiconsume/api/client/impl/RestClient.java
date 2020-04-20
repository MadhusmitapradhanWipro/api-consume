package com.poc.apiconsume.apiconsume.api.client.impl;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.poc.apiconsume.apiconsume.api.client.IRestClient;
import com.poc.apiconsume.apiconsume.dto.AbstractBaseDTO;

@Component
public class RestClient implements IRestClient {

	@Autowired
	private RestTemplate template;

	public <T extends AbstractBaseDTO> T invokeGET(final String url, final HttpEntity<?> requestEntity,
			final Class<T> responseType, final Map<String, Object> queryParams) throws Exception {
		try {
			final String finalURL = appendQueryParamsToUrl(url, queryParams);

			final ResponseEntity<T> exchange = template.exchange(finalURL, HttpMethod.GET, requestEntity, responseType);

			if (exchange.getStatusCode() == HttpStatus.OK) {
				return exchange.getBody();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return null;
	}

	public <T extends AbstractBaseDTO> T invokePOST(String url, RequestEntity<?> requestEntity, Class<T> responseType)
			throws Exception {
		try {
			final ResponseEntity<T> exchange = template.exchange(requestEntity, responseType);
			/*
			 * if (exchange.getStatusCode() == HttpStatus.OK) {
			 * System.out.println(exchange.getBody()); return exchange.getBody(); }
			 */
			return exchange.getBody();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public <T extends AbstractBaseDTO> T invokePut(final String url, final HttpEntity<?> requestEntity,
			final Class<T> responseType) throws Exception {
		try {
			final ResponseEntity<T> exchange = template.exchange(new URI(url), HttpMethod.PUT, requestEntity,
					responseType);
			if (exchange.getStatusCode() == HttpStatus.OK) {
				return exchange.getBody();
			}

		} catch (Exception e) {
			throw new Exception(e);
		}
		return null;
	}

	/**
	 * @param url
	 * @param queryParams
	 * @return
	 */
	private String appendQueryParamsToUrl(final String url, final Map<String, Object> queryParams) {
		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		if (queryParams != null && !queryParams.isEmpty()) {
			for (String key : queryParams.keySet()) {
				builder.queryParam(key, queryParams.get(key));
			}
		}
		return builder.build().encode().toUri().toString();
	}
	

}