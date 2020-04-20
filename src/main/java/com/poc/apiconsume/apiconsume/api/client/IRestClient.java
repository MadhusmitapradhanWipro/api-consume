package com.poc.apiconsume.apiconsume.api.client;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;

import com.poc.apiconsume.apiconsume.dto.AbstractBaseDTO;

public interface IRestClient {

	/**
	 * Method to be used when passing request parameters in URL. Only calls HTTP
	 * GET Method
	 * 
	 * @param url
	 * @param method
	 * @param requestEntity
	 * @param responseType
	 * @param queryParams
	 * @return
	 * @throws Exception
	 */
	public abstract <T extends AbstractBaseDTO> T invokeGET(String url,
			HttpEntity<?> requestEntity, Class<T> responseType,
			Map<String, Object> queryParams)
			throws Exception;

	/**
	 * @param requestEntity
	 * @param responseType
	 * @return
	 * @throws Exception
	 */

	public abstract <T extends AbstractBaseDTO> T invokePOST(String url,
			RequestEntity<?> requestEntity, Class<T> responseType)
			throws Exception;

	/**
	 * @param url
	 * @param requestEntity
	 * @return
	 * @throws Exception
	 */
	public abstract <T extends AbstractBaseDTO> T invokePut(String url,
			HttpEntity<?> requestEntity, final Class<T> responseType)
			throws Exception;

}