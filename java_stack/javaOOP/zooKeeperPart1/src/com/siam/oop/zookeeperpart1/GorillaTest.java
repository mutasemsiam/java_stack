package com.siam.oop.zookeeperpart1;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gorilla1 = new Gorilla(50);
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.eatBananas();
		gorilla1.eatBananas();
		gorilla1.climb();
		System.out.println(gorilla1.getEnergyLevel());

	}

}
