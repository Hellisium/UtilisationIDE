package pizza.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pizza.spring.modele.Pizza;

@Repository
public class PizzaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Pizza> getAllPizza() {
		return em.createQuery("select p from Pizza p", Pizza.class)
				 .getResultList();
	}
	
}
