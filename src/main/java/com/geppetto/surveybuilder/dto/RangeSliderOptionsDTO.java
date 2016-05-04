package com.geppetto.surveybuilder.dto;

import java.io.Serializable;

public class RangeSliderOptionsDTO implements Serializable {
	private static final long serialVersionUID = 4286965150098013243L;

	private Long floor;
	private Long ceil;

	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}

	public Long getCeil() {
		return ceil;
	}

	public void setCeil(Long ceil) {
		this.ceil = ceil;
	}

}
