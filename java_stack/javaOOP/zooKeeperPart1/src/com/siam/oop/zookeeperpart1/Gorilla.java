package com.siam.oop.zookeeperpart1;

public class Gorilla extends Mammal {

	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown something");
		setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("The gorilla has eaten a banana");
		setEnergyLevel(getEnergyLevel() + 5);
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree");
		setEnergyLevel(getEnergyLevel() - 10);
	}
}


