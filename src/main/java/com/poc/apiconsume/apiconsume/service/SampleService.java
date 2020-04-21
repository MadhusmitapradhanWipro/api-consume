package com.poc.apiconsume.apiconsume.service;

import com.poc.apiconsume.apiconsume.dto.request.SampleRequestDTO;
import com.poc.apiconsume.apiconsume.dto.response.SampleResponseDTO;

public interface SampleService {
	public SampleResponseDTO sampleFetchAPIMethod(SampleRequestDTO serviceRequestBody) throws Exception;
}
