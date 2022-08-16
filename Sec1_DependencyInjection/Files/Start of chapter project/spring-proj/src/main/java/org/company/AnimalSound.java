package org.company;

public class AnimalSound {

	public AnimalSound() {
	}
	
	private Animal animal;

	public AnimalSound(Animal animal) {
		this.animal = animal;
	}

	public void shout() {
		animal.makeNoise();
	}
}
