package modele;
import java.awt.List;
import java.util.ArrayList;

public class Client {
	private String nom;
	private String email;
	private ArrayList<Commande> listeCmd = new ArrayList<Commande>();
	
	public boolean nouvelleCmdClient(Commande cmd) {
		//ajouter la commande dans la liste
		
		return false;

	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
