package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VenteSW {
	private ArrayList<Client> listeProduits = new ArrayList<Client>();
	private Catalogue catalogue;

	// f1
	public double consulterProd(int numeroProd, String monnaie) {
		double prixConverti;

		Produit prod = catalogue.consulterProd(numeroProd);

		prixConverti = 0;// appel au service web

		return prixConverti;
	}

	// f2
	public Commande nouvelleCommande(Client cli) {

		// récupérer valeur séquence Commande
		int seqCommande = 0;

		Commande cmd = new Commande(seqCommande, cli);

		return cmd;
	}

	// f3
	public DetailCde consulterCommande(int numCmd) {
		DetailCde detail = new DetailCde();
		
		Connection conn = ConnexionJDBC.connexion(); 

		// récupérer commande avec numero
		
		
		String req = "SELECT  FROM commande WHERE numCde = " + numCmd;
		Statement stmt = conn.createStatement();
		//execu/on de la requete
		ResultSet res = stmt.executeQuery(req);
		
		Commande cde = res.;
		detail.setCde(cde);

		return detail;
	}

	// f5
	public boolean enregistrerLivCmd(int numCmd) throws ClassNotFoundException {

		try {
			Connection conn = ConnexionJDBC.connexion();

			// chercher la commande dans la base de donn�es et la mettre dans
			// variable

			String req = "UPDATE commande SET dateLiv = SYSDATE WHERE numCde = " + numCmd;
			Statement stmt = conn.createStatement();
			// execu/on de la requete
			stmt.executeQuery(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
