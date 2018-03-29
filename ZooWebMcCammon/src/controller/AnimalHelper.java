package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animal;

public class AnimalHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ZooMcCammon");
	
	public void insertItem(Animal toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Animal> showAllAnimals() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Animal> allResults = em.createQuery("select li from Animal li", Animal.class);
		List<Animal> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	public List<Animal> showMammals() {
		// TODO Auto-generated method stub
		int id = 1;
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Animal> allResults = em.createQuery("select li from Animal li where li.animal_type_id = :id", Animal.class);
		allResults.setParameter("animal_type_id", id);
		List<Animal> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	
	
	public List<Animal> findAnimal(int zooId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Animal> allResults = em.createQuery("select li from Animal li where li.zoo_id = :zooId", Animal.class);
		allResults.setParameter("zooId", zooId);
		List<Animal> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
	
	public Animal searchForAnimalById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Animal found = em.find(Animal.class, id);
		em.close();
		return found;
	}
	
	public void deleteItem(Animal toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal> typedQuery = em.createQuery("select li from Animal li where li.name = :selectedItem", Animal.class);
		typedQuery.setParameter("selectedItem", toDelete.getName());
		typedQuery.setMaxResults(1);
		Animal result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deleteById(Animal toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Animal> typedQuery = em.createQuery("SELECT animal FROM Animal animal WHERE animal.id = :selectedId", Animal.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Animal result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateAnimal(Animal toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}