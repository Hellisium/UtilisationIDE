package pizza.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizza.spring.dao.CommandeDao;
import pizza.spring.modele.Commande;
import pizza.spring.modele.Pizza;

@Service
public class CommandeService {
	
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private PizzaService pizzaService;
	
	@Transactional
    public Commande commander(DonneesCommandeDto donneesCommandeDto) {
        Commande commande = new Commande(
        		donneesCommandeDto.getNom(),
        		donneesCommandeDto.getTelephone()
        );
        List<Pizza> pizzaCommande = new ArrayList<Pizza>();
        List<Pizza> allPizza = pizzaService.getAllPizza();
        for(String pizzaDto : donneesCommandeDto.getPizzas()) {
            for(Pizza pizza : allPizza){
                if(pizza.getNom().equals(pizzaDto)){
                	pizzaCommande.add(pizza);
                }
            }
        }
        commande.setPizzas(pizzaCommande);
        commandeDao.save(commande);
        return commande;
    }
	
    @Transactional
    public Commande update(Commande commande) {
        commandeDao.update(commande);
        return commande;
    }

    @Transactional(readOnly = true)
    public List<Commande> getAllCommande() {
        return commandeDao.getAllCommande();
    }
    
    @Transactional(readOnly = true)
    public List<Commande> getAllEnAttente() {
        return commandeDao.getAllEnAttente();
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<String[]> getNbParTypePizza(List<Pizza> pizzas){
    	@SuppressWarnings("rawtypes")
		Set set = new HashSet();
    	set.addAll(pizzas);
    	@SuppressWarnings("rawtypes")
		List<Pizza> pizzasSansDoublon = new ArrayList(set);
    	
    	@SuppressWarnings("rawtypes")
		List<String[]> nbParTypePizza = new ArrayList();
    	int nb = 0;
    	String[] donneesNbParTypePizza;
    	for(Pizza pizza1 : pizzasSansDoublon) {
    		for(Pizza pizza2 : pizzas) {
    			if(pizza1.getNom().equals(pizza2.getNom())) {
    				nb++;
    			}
    		}
    		donneesNbParTypePizza = new String[3];
    		donneesNbParTypePizza[0] = pizza1.getNom();
    		donneesNbParTypePizza[1] = "" + nb;
    		donneesNbParTypePizza[2] = "" + (nb * Double.valueOf(pizza1.getPrix())/100);
    		
    		nbParTypePizza.add(donneesNbParTypePizza);
    		nb = 0;
    	}
    	return nbParTypePizza;
    }

}
