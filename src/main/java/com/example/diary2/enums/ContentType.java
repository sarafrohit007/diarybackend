package com.example.diary2.enums;

public enum ContentType {
	
	CONTENT(1,"Content"),
	COMMENT(2,"Comment");
	
	private int id;
	
	private String description;
	
	ContentType() {
		
	}
	
	ContentType(int id,String description) {
		this.id=id;
		this.description=description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
