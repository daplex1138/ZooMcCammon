package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SkinType;

public class SkinTypeHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public List<SkinType> getAll() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<SkinType> allResults = em.createQuery("SELECT skinType FROM SkinType skinType", SkinType.class);
		List<SkinType> results = allResults.getResultList();
		em.close();
		return results;
	}
}
