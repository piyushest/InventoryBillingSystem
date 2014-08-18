package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Inventory;
import model.InventoryPK;


public class InventoryDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;

	public void create(Inventory inventory) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(inventory);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Inventory> read() {
		List<Inventory> allInventory = new ArrayList<Inventory>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		allInventory = entityManager.createNamedQuery("Inventory.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return allInventory;
	}

	public void update(Inventory inventory) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(Inventory.class,
				inventory.getId());
		entityManager.merge(inventory);
		entityManager.getTransaction().commit();
	}
	
	public Inventory readUser(InventoryPK id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Inventory inventory = em.find(Inventory.class, id);
		
		em.getTransaction().commit();
		em.close();
		return inventory;
	}
}
