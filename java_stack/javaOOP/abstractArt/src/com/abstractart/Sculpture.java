package com.abstractart;

public class Sculpture extends Art {
	
	private String material;
	
	public Sculpture(String title, String author, String material) {
		super(title, author);
		this.material = material;
		// TODO Auto-generated constructor stub
	}
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Title: " + this.getTitle() + "|| Author: " + this.getAuthor() +
				"|| Material: " + this.getMaterial() + "|| Desc: " + this.getDescription());
		
	}
	

}
