package com.geppetto.surveybuilder.domain.core;


/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@Entity

@Table(name="Country")

@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel( value = "Country", description = "country" )

public class Country  {


	


	@ApiModelProperty( value = "The standard id attribute - System generated", required = true ) 
	@Id 
 	@GeneratedValue
 	long id;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String common_name;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String formal_name;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String iso_three_letter_code;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String capital;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String currency_name;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String telephone_code;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCommon_name() {
		return common_name;
	}



	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}



	public String getFormal_name() {
		return formal_name;
	}



	public void setFormal_name(String formal_name) {
		this.formal_name = formal_name;
	}



	public String getIso_three_letter_code() {
		return iso_three_letter_code;
	}



	public void setIso_three_letter_code(String iso_three_letter_code) {
		this.iso_three_letter_code = iso_three_letter_code;
	}



	public String getCapital() {
		return capital;
	}



	public void setCapital(String capital) {
		this.capital = capital;
	}



	public String getCurrency_name() {
		return currency_name;
	}



	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}



	public String getTelephone_code() {
		return telephone_code;
	}



	public void setTelephone_code(String telephone_code) {
		this.telephone_code = telephone_code;
	}



	@Override
	public String toString() {
		return "Country [id=" + id + ", common_name=" + common_name
				+ ", formal_name=" + formal_name + ", iso_three_letter_code="
				+ iso_three_letter_code + ", capital=" + capital
				+ ", currency_name=" + currency_name + ", telephone_code="
				+ telephone_code + "]";
	}




}