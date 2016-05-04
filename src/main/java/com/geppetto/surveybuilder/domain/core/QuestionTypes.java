package com.geppetto.surveybuilder.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@Entity

@Table(name="question_types")

@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel( value = "question_types", description = "question_types" )
public class QuestionTypes {
	
	@ApiModelProperty( value = "The standard id attribute - System generated", required = true ) 
	@Id
	@GeneratedValue
	long id;
	
	@ApiModelProperty( value = "description", required = true ) 
	@Column
	String name;
	
	/*@ApiModelProperty( value = "description", required = true ) 
	@Column
	long question_type_id;*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "QuestionTypes [id=" + id + ", name=" + name + "]";
	}

	/*public long getQuestion_type_id() {
		return question_type_id;
	}

	public void setQuestion_type_id(long question_type_id) {
		this.question_type_id = question_type_id;
	}*/

	/*@Override
	public String toString() {
		return "QuestionTypes [id=" + id + ", name=" + name
				+ ", question_type_id=" + question_type_id + "]";
	}*/
	
	

}
