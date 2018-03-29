package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Zoo;

public class ZooHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public void insertItem(Zoo toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Zoo> showAllZoos() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Zoo> allResults = em.createQuery("select li from Zoo li", Zoo.class);
		List<Zoo> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	public Zoo searchForZooById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Zoo foundItem = em.find(Zoo.class, idToEdit);
		em.close();
		return foundItem;
	}
	public Zoo findZooByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Zoo> allResults = em.createQuery("select li from Zoo li where li.nameOfZoo = :name", Zoo.class);
		allResults.setParameter("name", name);
		allResults.setMaxResults(1);
		Zoo allItems = allResults.getSingleResult();
		em.close();
		return allItems;
	}
	
	public void deleteZoo(Zoo toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Zoo> typedQuery = em.createQuery("select li from Zoo li where li.nameOfZoo = :selectedItem", Zoo.class);
		typedQuery.setParameter("selectedItem", toDelete.getNameOfZoo());
		typedQuery.setMaxResults(1);
		Zoo result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deleteItemById(Zoo toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Zoo> typedQuery = em.createQuery("SELECT zoo FROM Zoo zoo WHERE zoo.id = :selectedId", Zoo.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Zoo result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateZoo(Zoo toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	

}