package pizza.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pizza.spring.modele.Commande;

@Repository
public class CommandeDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Commande commande) {
		em.persist(commande);
	}
	
	public void update(Commande commande) {
		em.merge(commande);
	}
	
	public List<Commande> getAllCommande() {
		return em.createQuery("select c from Commande c", Commande.class)
				 .getResultList();
	}
	
	public List<Commande> getAllEnAttente() {
        return em.createQuery("select c from Commande c where c.enAttente = 0", Commande.class)
                .getResultList();
    }

}
