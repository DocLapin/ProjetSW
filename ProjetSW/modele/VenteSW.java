package modele;

import java.util.ArrayList;

public class VenteSW {
	private ArrayList<Client> listeProduits = new ArrayList<Client>();
	private Catalogue catalogue;

	//f1
	public double consulterProd(int numeroProd, String monnaie) {
		double prixConverti;
		
		Produit prod = catalogue.consulterProd(numeroProd);
		
		prixConverti = 0;//appel au service web
		
		return prixConverti;
	}
	
	
	//f2
	public Commande nouvelleCommande(Client cli) {
		
		//récupérer valeur séquence Commande
		int seqCommande = 0;
		
		Commande cmd = new Commande(seqCommande,cli);
		
		
		return cmd;
	}
	
	//f3
	public DetailCde consulterCommande(int numCmd) {
		DetailCde detail = new DetailCde();
		
		//récupérer commande avec numero
		Commande cde = null;
		detail.setCde(cde);
		
		return detail;
	}
	
	//f5
	public boolean enregistrerLivCmd(int numCmd) {
		
		//chercher la commande et la mettre dans variable
		Commande 
		
	}
	
	
}
