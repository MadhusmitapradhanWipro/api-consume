package com.poc.apiconsume.apiconsume.dto.request;

import java.util.List;

import com.poc.apiconsume.apiconsume.dto.AbstractBaseDTO;

public class SampleRequestDTO extends AbstractBaseDTO {
	private String name;
	private List<String> movies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMovies() {
		return movies;
	}

	public void setMovies(List<String> movies) {
		this.movies = movies;
	}

}
