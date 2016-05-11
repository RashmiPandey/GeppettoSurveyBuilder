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
@Table(name = "Store")
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Store", description = "Store")
public class Store {
	
	@ApiModelProperty( value = "The standard id attribute - System generated", required = true )
	@Id
	@GeneratedValue
	private int id;
	
	@ApiModelProperty(value = "description", required = true)
	@Column
	private String store_name;
	
	@ApiModelProperty(value = "description", required = true)
	@Column
	private String location;
	
	@ApiModelProperty(value = "description", required = true)
	@Column
	private long route_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getRoute_id() {
		return route_id;
	}
	public void setRoute_id(long route_id) {
		this.route_id = route_id;
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", store_name=" + store_name + ", location=" + location + ", route_id=" + route_id
				+ "]";
	}
	

}
