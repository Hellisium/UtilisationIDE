package pizza.spring.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pizza.spring.modele.CommandeParClient;
import pizza.spring.modele.PizzaParCategorie;
import pizza.spring.service.RapportActiviteService;

@Controller
public class RapportActiviteControleur {
	
	@Autowired
	private RapportActiviteService rapportActiviteService;
	
	@GetMapping("/rapportActivite")
	public String rapportActivite(Model model) {
		List<CommandeParClient> commandeParClient = rapportActiviteService.getCommandeParClient();
		List<PizzaParCategorie> pizzaParCategorie = rapportActiviteService.getPizzaParCategorie();
		model.addAttribute("commandeParClient", commandeParClient);
		model.addAttribute("pizzaParCategorie", pizzaParCategorie);
		return "rapportActivite";
	}

}
