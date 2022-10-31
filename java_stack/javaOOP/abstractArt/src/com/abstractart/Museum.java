package com.abstractart;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------Paintings-------");
		Painting painting1 = new Painting("tree", "Jack", "Oil");
		painting1.viewArt();
		System.out.println();
		Painting painting2 = new Painting("Moon", "John", "nice moon", "Watercolor");
		painting2.viewArt();
		System.out.println();
		Painting painting3 = new Painting("Sun", "Well", "Watercolor");
		painting3.viewArt();
		System.out.println();
		System.out.println("-------Sculptures-------");
		
		Sculpture one = new Sculpture("Lion", "Smith", "Marble");
		one.viewArt();
		System.out.println();
		Sculpture two = new Sculpture("Jaguar", "Rio", "Bronze");
		two.viewArt();
		System.out.println();
		Sculpture three = new Sculpture("Cat", "Smith", "big one", "Porcelain");
		three.viewArt();
		
		
	}

}
