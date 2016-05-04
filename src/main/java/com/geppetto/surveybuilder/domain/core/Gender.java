package com.geppetto.surveybuilder.domain.core;

public enum Gender {

	MALE,FEMALE;
	
	public static Gender getUseType(String value) {
		return Gender.valueOf(value);
	}

	
}
