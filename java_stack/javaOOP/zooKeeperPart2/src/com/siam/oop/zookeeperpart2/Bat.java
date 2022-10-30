package com.siam.oop.zookeeperpart2;

public class Bat extends Mammal {
	
	public Bat() {
		setEnergyLevel(300);
	}
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	public void attackTown() {
		System.out.println("The bat has attacked a town");
		setEnergyLevel(getEnergyLevel() - 100);
	}
	
	public void eatHumans() {
		System.out.println("The bat has eaten a human");
		setEnergyLevel(getEnergyLevel() + 25);
	}
	
	public void fly() {
		System.out.println("The bat has flown");
		setEnergyLevel(getEnergyLevel() - 50);
	}
	
}
