package com.abstractart;

public class Painting extends Art {

	private String paintType;
	
	public Painting(String title, String author, String paintType) {
		super(title, author);
		this.paintType = paintType;
		// TODO Auto-generated constructor stub
	}
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
		// TODO Auto-generated constructor stub
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		System.out.println("Title: " + this.getTitle() + "|| Author: " + this.getAuthor() +
				"|| Paint type: " + this.getPaintType() + "|| Desc: " + this.getDescription());
		
	}
	
}
