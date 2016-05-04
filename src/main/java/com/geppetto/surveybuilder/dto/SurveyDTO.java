package com.geppetto.surveybuilder.dto;

import java.util.List;

public class SurveyDTO {

	private Long id;

	private Long client_id;

	private Long country_id;

	private Long product_id;

	private List<QuestionDTO> questions;

	private String survey_name;

	private String survey_description;

	private String survey_notes;

	private String country_name;

	private String client_name;

	private String product_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public Long getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

	public String getSurvey_name() {
		return survey_name;
	}

	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}

	public String getSurvey_description() {
		return survey_description;
	}

	public void setSurvey_description(String survey_description) {
		this.survey_description = survey_description;
	}

	public String getSurvey_notes() {
		return survey_notes;
	}

	public void setSurvey_notes(String survey_notes) {
		this.survey_notes = survey_notes;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

}
