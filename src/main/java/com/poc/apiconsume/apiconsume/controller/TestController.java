package com.poc.apiconsume.apiconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.apiconsume.apiconsume.dto.request.SampleRequestDTO;
import com.poc.apiconsume.apiconsume.dto.response.SampleResponseDTO;
import com.poc.apiconsume.apiconsume.service.SampleServiceImpl;

@RestController
public class TestController {
	@Autowired
	SampleServiceImpl service;
	
	@PostMapping("/test")
	public SampleResponseDTO test(@RequestBody SampleRequestDTO request) throws Exception {
		return service.sampleFetchAPIMethod(request);
	}
}
