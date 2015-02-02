package modele;

import java.util.ArrayList;

public class Client {

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	private String nom;
	private String email;
	private ArrayList<Commande> listeCmd = new ArrayList<Commande>();

	public boolean nouvelleCmdClient(Commande cmd) {
		// ajouter la commande dans la liste
		return listeCmd.add(cmd);
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
