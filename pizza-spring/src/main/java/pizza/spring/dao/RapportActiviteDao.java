package pizza.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pizza.spring.modele.CommandeParClient;
import pizza.spring.modele.PizzaParCategorie;

@Repository
public class RapportActiviteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<CommandeParClient> getCommandeParClient() {
		return em.createQuery("SELECT NEW pizza.spring.modele.CommandeParClient(commande.nom, count(*)) FROM Commande commande GROUP BY commande.nom", CommandeParClient.class)
				.getResultList();
	}
	
	public List<PizzaParCategorie> getPizzaParCetegorie() {
		return em.createQuery("SELECT NEW pizza.spring.modele.PizzaParCategorie(categorie.nom, count(commande), sum(pizza.prix)) FROM Pizza pizza JOIN pizza.commande commande JOIN pizza.categorie categorie GROUP BY categorie", PizzaParCategorie.class)
				.getResultList();
	}

}
