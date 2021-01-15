package pizza.spring.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pizza.spring.modele.Commande;
import pizza.spring.modele.Pizza;
import pizza.spring.service.CommandeService;
import pizza.spring.service.DonneesCommandeDto;
import pizza.spring.service.PizzaService;

@Controller
public class CommandeControleur {
	
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private CommandeService commandeService;
	
	@GetMapping({"/commande"})
	public String commande(Model model, DonneesCommandeDto donneesCommandeDto) {
		List<Pizza> allPizza = pizzaService.getAllPizza();
		List<Pizza> pizzasDisponible = new ArrayList<>();
		for(Pizza pizza : allPizza) {
			if(pizza.isDisponible()) {
				pizzasDisponible.add(pizza);
			}
		}
		model.addAttribute("pizzasDisponible", pizzasDisponible);
		return "commande";
	}
	
	@PostMapping("/commande")
	public String commander(@Validated DonneesCommandeDto donneesCommandeDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
        	List<Pizza> allPizzas = pizzaService.getAllPizza();
    		List<Pizza> pizzasDisponible = new ArrayList<>();
    		for(Pizza pizza : allPizzas) {
    			if(pizza.isDisponible()) {
    				pizzasDisponible.add(pizza);
    			}
    		}
    		model.addAttribute("pizzasDisponible", pizzasDisponible);
    		return "commande";
        }
        Commande commande = commandeService.commander(donneesCommandeDto);
        
        List<String[]> nbParTypePizza = commandeService.getNbParTypePizza(commande.getPizzas());

        model.addAttribute("commande", commande);
        model.addAttribute("nbParTypePizza", nbParTypePizza);
        return "recapitulatif";
    }
	
	@GetMapping("/recapitulatif")
    public String recapitulatif(Model model){
        return "recapitulatif";
    }

}
