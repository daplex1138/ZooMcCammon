package model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.DietAttributeConverter;
import controller.GenderAttributeConverter;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="animal_type_id")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	//@Column(name = "animal_type_id")
	@ManyToOne
	@JoinColumn (name = "animal_type_id")
	// This atrribute converter is here as a placeholder.  For some reason,
	// the discriminator is ignoring this converter, resulting in a type mismatch.
	//@Convert(converter = AnimalTypeAttributeConverter.class)
	private AnimalType animalType;
	@Column(name = "gender_id")
	@Convert(converter = GenderAttributeConverter.class)
	private String gender;
	@Column(name = "weight")
	private double weight;
	@Column(name = "length")
	private double length;
	@Column(name = "height")
	private double height;
	@Column(name = "diet_id")
	@Convert(converter = DietAttributeConverter.class)
	private String diet;
	@Column(name = "nocturnal")
	private boolean isNocturnal;
	@Column(name = "lay_eggs")
	private boolean laysEggs;
	@ManyToOne
	@JoinColumn (name = "zoo_id")
	private Zoo zoo;
	@Column(name = "zoo_id", updatable=false, insertable=false)
	private int zoo_id;

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, AnimalType animalType, String gender, double weight, double length, double height, String diet,
			boolean isNocturnal, boolean laysEggs, Zoo zoo) {
		super();
		this.setName(name);
		this.setAnimalType(animalType);
		this.setGender(gender);
		this.setWeight(weight);
		this.setLength(length);
		this.setHeight(height);
		this.setDiet(diet);
		this.setIsNocturnal(isNocturnal);
		this.setLaysEggs(laysEggs);
		this.setZoo(zoo);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public AnimalType getAnimalType() {
		return this.animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getDiet() {
		return this.diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public boolean getIsNocturnal() {
		return isNocturnal;
	}

	public void setIsNocturnal(boolean isNocturnal) {
		this.isNocturnal = isNocturnal;
	}

	public boolean getLaysEggs() {
		return laysEggs;
	}

	public void setLaysEggs(boolean laysEggs) {
		this.laysEggs = laysEggs;
	}

	public Zoo getZoo() {
		return this.zoo;
	}
	
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

	public String getProfile() {
		return "Id = " + this.getId() + "; Name = " + this.getName() + "; Type = " + this.getAnimalType()
				+ "; Gender = " + this.getGender() + "; Weight = " + this.getWeight() + " lbs" + "; Length = "
				+ this.getLength() + " inches" + "; Height = " + this.getHeight() + " inches" + "; Diet = "
				+ this.getDiet() + "; Is Nocturnal = " + this.getIsNocturnal() + "; Lays Eggs = " + this.laysEggs;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", type=" + animalType + ", gender=" + gender + ", weight=" + weight
				+ ", length=" + length + ", height=" + height + ", diet=" + diet + ", isNocturnal=" + isNocturnal
				+ ", laysEggs=" + laysEggs + "]";
	}

}
