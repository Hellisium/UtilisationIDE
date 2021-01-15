package pizza.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizza.spring.dao.PizzaDao;
import pizza.spring.modele.Pizza;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaDao pizzaDao;
	
	@Transactional
	public List<Pizza> getAllPizza() {
		return pizzaDao.getAllPizza();
	}
	
}
