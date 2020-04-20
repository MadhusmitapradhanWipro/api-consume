package com.poc.apiconsume.apiconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiconsumeApplication {

	/*
	 * @Bean public RestTemplate getRestTemplate() { final RestTemplate restTemplate
	 * = new RestTemplate( getMessageConverters()); return restTemplate; }
	 *//**
		 * @return
		 *//*
			 * private List<HttpMessageConverter<?>> getMessageConverters() { final
			 * List<HttpMessageConverter<?>> converters = new
			 * ArrayList<HttpMessageConverter<?>>(); converters.add(new
			 * MappingJackson2HttpMessageConverter()); return converters; }
			 */

	/*
	 * @Autowired static SampleServiceImpl serviceImpl;
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiconsumeApplication.class, args);
		/*
		 * SampleRequestDTO requestDTO = new SampleRequestDTO();
		 * requestDTO.setName("Test Name"); requestDTO.setMovies(Arrays.asList("Movie1",
		 * "Movie2")); SampleResponseDTO result =
		 * serviceImpl.sampleFetchAPIMethod(requestDTO); System.out.println("RESULT: " +
		 * result);;
		 */
	}

}
