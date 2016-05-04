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

@Table(name="Client")

@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel( value = "Client", description = "represents a client" )

public class Client  {


	@ApiModelProperty( value = "The standard id attribute - System generated", required = true ) 
	@Id 
 	@GeneratedValue
 	long Id;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	long Client_id;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String Client_name;



	@ApiModelProperty( value = "description", required = true ) 
	@Column
 	String Notes;



	@ApiModelProperty( value = "description", required = false ) 
	@Column
 	Long Createdby;



	@ApiModelProperty( value = "create_date", required = true ) 
	@Column
 	String Create_Date;



	@ApiModelProperty( value = "description", required = false ) 
	@Column
	Long Modifiedby;



	@ApiModelProperty( value = "modified_date", required = true ) 
	@Column
 	String Modified_Date;


	public String getCreate_Date() {
		return Create_Date;
	}


	public void setCreate_Date(String create_Date) {
		Create_Date = create_Date;
	}


	public String getModified_Date() {
		return Modified_Date;
	}


	public void setModified_Date(String modified_Date) {
		Modified_Date = modified_Date;
	}


	public void setId(long Id) {
		this.Id = Id;
	}


	public long getId() {
		return Id;
	}

	public void setClient_id(long Client_id) {
		this.Client_id = Client_id;
	}


	public long getClient_id() {
		return Client_id;
	}

	public void setClient_name(String Client_name) {
		this.Client_name = Client_name;
	}


	public String getClient_name() {
		return Client_name;
	}

	public void setNotes(String Notes) {
		this.Notes = Notes;
	}


	public String getNotes() {
		return Notes;
	}

	public void setCreatedby(long Createdby) {
		this.Createdby = Createdby;
	}


	public long getCreatedby() {
		if (Createdby != null) 
		  return Createdby.longValue();
		else
		  return -1;
	}

	public void setModifiedby(long Modifiedby) {
		this.Modifiedby = Modifiedby;
	}


	public long getModifiedby() {
		if (Modifiedby != null) 
		  return Modifiedby.longValue();
		else
		  return -1;
	}


}