package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DietType;


public class DietHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public List<DietType> getAll() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<DietType> allResults = em.createQuery("SELECT dietType FROM DietType dietType", DietType.class);
		List<DietType> results = allResults.getResultList();
		em.close();
		return results;
	}
	
}
