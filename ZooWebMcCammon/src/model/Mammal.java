package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mammal")
@DiscriminatorValue("1")
public class Mammal extends Animal{
	private int id;
	@Column(name = "num_of_legs")
	private int numOfLegs;
	@Column(name = "bipedal")
	private boolean isBipedal;
	@Column(name = "has_fur")
	private boolean hasFur;
	
	public Mammal() {
		super();
	}

	public Mammal(String name, AnimalType animalType, String gender, double weight, double length, double height, String diet,
			boolean isNocturnal, boolean laysEggs, int numOfLegs, boolean bipedal, boolean hasFur, Zoo zoo) {
		super(name, animalType, gender, weight, length, height, diet, isNocturnal, laysEggs, zoo);
		this.setNumOfLegs(numOfLegs);
		this.setIsBipedal(bipedal);
		this.setHasFur(hasFur);
	}
	
	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public boolean getIsBipedal() {
		return isBipedal;
	}

	public void setIsBipedal(boolean bipedal) {
		this.isBipedal = bipedal;
	}

	public boolean getHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	@Override
	public String getProfile() {
		return super.getProfile() + "; Type = Mammal" +
									"; Number of Legs = " + this.getNumOfLegs() +
									"; Is Bipedal = " + this.getIsBipedal() +
									"; Has Fur = " + this.hasFur;
	}
	
	@Override
	public String toString() {
		return "Mammal [id=" + id + ", numOfLegs=" + numOfLegs + ", isBipedal=" + isBipedal + ", hasFur=" + hasFur
				+ "]";
	}

	public String getGroomingNeeds() {
		if (this.hasFur) {
			return "This animal needs grooming.";
		}
		
		return "This animal does not need grooming.";
	}
}
