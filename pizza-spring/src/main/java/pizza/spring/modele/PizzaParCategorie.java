package pizza.spring.modele;

public class PizzaParCategorie {
	
	private String categorie;
	private long nombre;
	private long prix;
	
	protected PizzaParCategorie() {
	}
	public PizzaParCategorie(String categorie, long nombre, long prix) {
		this.categorie = categorie;
		this.nombre = nombre;
		this.prix = prix;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public long getNombre() {
		return nombre;
	}
	public void setNombre(long nombre) {
		this.nombre = nombre;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}

}
