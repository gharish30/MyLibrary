package com.hash.main.dto;

import lombok.Data;

@Data
public class BorrowerDto {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BorrowerDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public BorrowerDto() {
		super();
	}

}
