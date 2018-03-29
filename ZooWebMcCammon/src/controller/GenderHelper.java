package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gender;

public class GenderHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public List<Gender> getAll() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Gender> allResults = em.createQuery("SELECT gender FROM Gender gender", Gender.class);
		List<Gender> results = allResults.getResultList();
		em.close();
		return results;
	}
}
