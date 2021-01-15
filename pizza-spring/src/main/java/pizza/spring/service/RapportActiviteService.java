package pizza.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizza.spring.dao.RapportActiviteDao;
import pizza.spring.modele.CommandeParClient;
import pizza.spring.modele.PizzaParCategorie;

@Service
public class RapportActiviteService {
	
	@Autowired
	private RapportActiviteDao rapportActiviteDao;
	
	@Transactional
	public List<CommandeParClient> getCommandeParClient() {
		return rapportActiviteDao.getCommandeParClient();
	}
	
	@Transactional
	public List<PizzaParCategorie> getPizzaParCategorie() {
		return rapportActiviteDao.getPizzaParCetegorie();
	}

}
