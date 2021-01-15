package pizza.spring.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String telephone;
	private Date dateEmission;
	private int enAttente;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DetailCommande",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> pizzas;
	
	
	protected Commande() {
	}
	public Commande(String nom, String telephone) {
		this.nom = nom;
		this.telephone = telephone;
		this.setDateEmission(new Date());
		this.setEnAttente(0);
		this.setPizzas(new ArrayList<>());;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}
	public int getEnAttente() {
		return enAttente;
	}
	public void setEnAttente(int enAttente) {
		this.enAttente = enAttente;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
