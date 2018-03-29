package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diet")
public class DietType {
	
	// This class models a look-up table in the DB.
	// It is only used so that we can create ddl's in the UI.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diet;
	
	public int getId() {
		return id;
	}
	public String getDiet() {
		return diet;
	}
}
