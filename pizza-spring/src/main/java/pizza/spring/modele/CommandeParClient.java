package pizza.spring.modele;

public class CommandeParClient {
	
	private String nom;
	private long nombre;
	
	protected CommandeParClient() {
	}
	public CommandeParClient(String nom, long nombre) {
		this.nom = nom;
		this.nombre = nombre;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getNombre() {
		return nombre;
	}
	public void setNombre(long nombre) {
		this.nombre = nombre;
	}

}
