package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adminregistereddistributor;

public class AdminregistereddistributorDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;

	public void create(Adminregistereddistributor distributor) {
		
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(distributor);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Adminregistereddistributor> read() {
		List<Adminregistereddistributor> allDistributor = new ArrayList<Adminregistereddistributor>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		allDistributor = entityManager.createNamedQuery("Adminregistereddistributor.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return allDistributor;
	}

	public void update(Adminregistereddistributor distributor) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(Adminregistereddistributor.class,
				distributor.getDistributorId());
		entityManager.merge(distributor);
		entityManager.getTransaction().commit();
	}
	public Adminregistereddistributor readUser(int distributorId) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Adminregistereddistributor distributor = em.find(Adminregistereddistributor.class, distributorId);
		
		em.getTransaction().commit();
		em.close();
		
		return distributor;
	}

}
