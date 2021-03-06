package com.poc.apiconsume.apiconsume.dto.response;

import java.util.List;

import com.poc.apiconsume.apiconsume.dto.AbstractBaseDTO;

public class SampleResponseDTO extends AbstractBaseDTO {
	private String id;
	private String createdAt;
	private String name;
	private List<String> movies;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

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
