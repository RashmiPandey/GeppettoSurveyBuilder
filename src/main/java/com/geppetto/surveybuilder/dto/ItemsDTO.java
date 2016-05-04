package com.geppetto.surveybuilder.dto;

import java.io.Serializable;

public class ItemsDTO implements Serializable {
	private static final long serialVersionUID = 3066061351379697906L;

	private Long id;

	private String src;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
