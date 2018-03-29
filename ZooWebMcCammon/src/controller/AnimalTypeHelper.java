package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AnimalType;

public class AnimalTypeHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public List<AnimalType> getAll() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<AnimalType> allResults = em.createQuery("SELECT animalType FROM AnimalType animalType", AnimalType.class);
		List<AnimalType> results = allResults.getResultList();
		em.close();
		return results;
	}
	
}
