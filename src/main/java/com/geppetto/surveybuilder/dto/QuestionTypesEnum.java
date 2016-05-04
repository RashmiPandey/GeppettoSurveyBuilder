package com.geppetto.surveybuilder.dto;

public enum QuestionTypesEnum {
	SINGLE_TEXTBOX(1), MULTIPLE_CHOICE(2), TAKE_PHOTO(3), ADD_PICTURE(4), RANGE_SLIDER(
			5);

	private final int code;

	private QuestionTypesEnum(int code) {
		this.code = code;
	}

	public int getvalue() {
		return this.code;
	}

}
