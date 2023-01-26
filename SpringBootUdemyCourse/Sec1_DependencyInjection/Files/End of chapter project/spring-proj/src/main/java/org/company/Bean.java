package org.company;

public class Bean {

	public Bean() {
	}
	
	private Animal animal;

	public Bean(Animal animal) {
		this.animal = animal;
	}

	public void shout() {
		animal.makeNoise();
	}
	//Added by me
	public void trick() {
		animal.showTalent();
	}
	
}


