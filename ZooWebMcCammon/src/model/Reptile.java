package model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import controller.SkinTypeAttributeConverter;

@Entity
@Table(name="reptile")
@DiscriminatorValue("2")
public class Reptile extends Animal {
	@Column(name = "id")
	private int id;
	@Column(name = "has_legs")
	private boolean hasLegs;
	@Column(name = "is_poisonous")
	private boolean isPoisonous;
	@Column(name = "skin_type_id")
	@Convert(converter = SkinTypeAttributeConverter.class)
	private String typeOfSkin;
	
	public Reptile() {
		super();
	}

	public Reptile(String name, AnimalType animalType, String gender, double weight, double length, double height, String diet,
			boolean isNocturnal, boolean laysEggs, boolean hasLegs, boolean isPoisonous, String typeOfSkin, Zoo zoo) {
		super(name, animalType, gender, weight, length, height, diet, isNocturnal, laysEggs, zoo);
		this.setHasLegs(hasLegs);
		this.setIsPoisonous(isPoisonous);
		this.setTypeOfSkin(typeOfSkin);
	}

	public boolean getHasLegs() {
		return hasLegs;
	}
	public void setHasLegs(boolean hasLegs) {
		this.hasLegs = hasLegs;
	}
	public boolean getIsPoisonous() {
		return isPoisonous;
	}
	public void setIsPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	public String getTypeOfSkin() {
		return typeOfSkin;
	}
	public void setTypeOfSkin(String typeOfSkin) {
		this.typeOfSkin = typeOfSkin;
	}

	@Override
	public String getProfile() {
		return super.getProfile() + "; Has Legs = " + this.getHasLegs() +
									"; Is Poisonous = " + this.getIsPoisonous() +
									"; Skin Type = " + this.getTypeOfSkin() +
									"; Use caution when handling = " + this.useCaution();
	}
	
	@Override
	public String toString() {
		return "Reptile [id=" + id + ", hasLegs=" + hasLegs + ", isPoisonous=" + isPoisonous + ", typeOfSkin="
				+ typeOfSkin + "]";
	}

	public boolean useCaution() {
		return this.isPoisonous;
	}
}
