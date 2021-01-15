package pizza.spring.service;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class DonneesCommandeDto {
	
	@NotEmpty(message="Veuillez renseigner votre nom")
	private String nom;
	
	@NotEmpty(message="Veuillez renseigner votre numero de telephone")
    @Pattern(regexp="^0[0-9]{9}$",message = "Veuillez renseigner votre numéro au format 0xxxxxxxxx")
	private String telephone;
	
	@NotEmpty(message="Veuillez choisir au moins une pizza")
	private List<String> pizzas;

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String tel) {
		this.telephone = tel;
	}
	public List<String> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<String> pizzas) {
		this.pizzas = pizzas;
	}

}
