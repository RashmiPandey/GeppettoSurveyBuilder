package com.geppetto.surveybuilder.domain.core;

public class Items_Dto {
	long id;
    String url;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Items_Dto [id=" + id + ", url=" + url + "]";
	}
    
    
}
