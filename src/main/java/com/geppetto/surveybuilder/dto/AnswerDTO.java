package com.geppetto.surveybuilder.dto;

import java.io.Serializable;

public class AnswerDTO implements Serializable {
	private static final long serialVersionUID = 9155423865045341325L;

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
