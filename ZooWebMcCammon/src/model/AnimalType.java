package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal_type")
public class AnimalType {
	
	// This class models a look-up table in the DB.
	// It is only used so that we can create ddl's in the UI.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String animal_type;
	
	public int getId() {
		return id;
	}
	public String getAnimal_type() {
		return animal_type;
	}
}
