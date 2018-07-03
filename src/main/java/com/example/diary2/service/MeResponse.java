package com.example.diary2.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MeResponse {

	private String id;

	private String name;


	public String getId() {
		return id;
	}


	public void setId(String id) {
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
		return "MeResponse [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
