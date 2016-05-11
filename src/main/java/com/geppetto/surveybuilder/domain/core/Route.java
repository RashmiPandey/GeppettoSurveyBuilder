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
@Table(name = "Route")
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Route", description = "Route")
public class Route {
	

	@ApiModelProperty( value = "The standard id attribute - System generated", required = true )
	@Id
	@GeneratedValue
	private int id;

	@ApiModelProperty(value = "description", required = true)
	@Column
	private String route_name;
	

	@ApiModelProperty(value = "description", required = true)
	@Column
	private String location;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", route_name=" + route_name + ", location=" + location + "]";
	}

}
