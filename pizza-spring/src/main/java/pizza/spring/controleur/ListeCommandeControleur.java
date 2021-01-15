package pizza.spring.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pizza.spring.modele.Commande;
import pizza.spring.service.CommandeService;

@Controller
public class ListeCommandeControleur {
	
	@Autowired
	private CommandeService commandeService;
	
	@GetMapping("/listeCommande")
	public String listeCommande(Model model) {
		List<Commande> listeCommande = commandeService.getAllEnAttente();
		if(listeCommande.isEmpty()) {
			return "accueil";
		}
		model.addAttribute("listeCommande", listeCommande);
		return "listeCommande";
	}
	
	@GetMapping("/listeCommande/detail")
	public String detail(Model model) {
		List<Commande> listeCommande = commandeService.getAllEnAttente();
		if(listeCommande.isEmpty()){
            return "accueil";
        }
        Commande commande = listeCommande.get(0);
        model.addAttribute("commande", commande);
        return "detail";
	}
	
	@PostMapping("/listeCommande/detail")
    public String commandePrete(Model model) {
        List<Commande> listeCommande = commandeService.getAllEnAttente();
        listeCommande.get(0).setEnAttente(1);
        commandeService.update(listeCommande.get(0));
        listeCommande = commandeService.getAllEnAttente();
        if(listeCommande.isEmpty()){
            return "accueil";
        }
        model.addAttribute("listeCommande", listeCommande);
        return "listeCommande";
    }

}
