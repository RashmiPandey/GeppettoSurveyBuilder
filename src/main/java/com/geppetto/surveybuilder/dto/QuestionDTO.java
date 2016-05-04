package com.geppetto.surveybuilder.dto;

import java.io.Serializable;
import java.util.List;

public class QuestionDTO implements Serializable {
	private static final long serialVersionUID = -9021307280584174833L;

	private Long id;

	private Long type_id;

	private String type_name;

	private String title;

	private List<AnswerDTO> answers;

	private List<ItemsDTO> items;

	private RangeSliderDTO range_slider;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	public List<ItemsDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemsDTO> items) {
		this.items = items;
	}

	public RangeSliderDTO getRange_slider() {
		return range_slider;
	}

	public void setRange_slider(RangeSliderDTO range_slider) {
		this.range_slider = range_slider;
	}

}
