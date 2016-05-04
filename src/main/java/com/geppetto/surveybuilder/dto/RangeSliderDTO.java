package com.geppetto.surveybuilder.dto;

import java.io.Serializable;

public class RangeSliderDTO implements Serializable {
	private static final long serialVersionUID = 8948977678808257035L;

	private Long id;
	private Long value;

	private RangeSliderOptionsDTO options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public RangeSliderOptionsDTO getOptions() {
		return options;
	}

	public void setOptions(RangeSliderOptionsDTO options) {
		this.options = options;
	}

}
