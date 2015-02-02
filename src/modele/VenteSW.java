package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VenteSW {
	private ArrayList<Client> listeProduits = new ArrayList<Client>();
	private Catalogue catalogue;
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		
//		Connection conn = ConnexionJDBC.connexion();
//		String req = "SELECT * FROM produit p where p.numProd="+ 2;
//		Statement stmt = conn.createStatement();
//		// execu/on de la requete
//		ResultSet res = stmt.executeQuery(req);
//		res.next();
//		System.out.println(res.getString("designation"));
//	}

	// f1
	public double consulterProd(int numeroProd, String monnaie) throws ClassNotFoundException {
		double prixConverti;

		Produit prod = catalogue.consulterProd(numeroProd);

		prixConverti = 0;// appel au service web

		return prixConverti;
	}

	// f2
	public Commande nouvelleCommande(Client cli) {

		// r√©cup√©rer valeur s√©quence Commande
		int seqCommande = 0;

		Commande cmd = new Commande(seqCommande, cli);

		return cmd;
	}

	// f3
	public DetailCde consulterCommande(int numCmd) throws SQLException, ClassNotFoundException {

		DetailCde detail = new DetailCde();
		Connection conn = ConnexionJDBC.connexion();

		Commande cmd;
		ArrayList<Produit> produits = null;

		String req = "SELECT * FROM produit p, detailCde d, commande c, client l "
				+ "WHERE d.numCde = c.numCde "
				+ "AND p.numProd = d.numProd AND c.numCde = " + numCmd;
		Statement stmt = conn.createStatement();
		// execu/on de la requete
		ResultSet res = stmt.executeQuery(req);

		// crÈer objet Commande
		cmd = new Commande(numCmd, new Client(res.getString("nom"),
				res.getString("email")));

		// Creer objets produits
		while (res.next()) {
			produits.add(new Produit(res.getInt("numProd"), res
					.getString("designation"), res.getDouble("prix")));
		}

		detail.setCde(cmd);
		detail.setPdt(produits);

		return detail;
	}

	// f5
	public boolean enregistrerLivCmd(int numCmd) throws ClassNotFoundException {

		try {
			Connection conn = ConnexionJDBC.connexion();

			// chercher la commande dans la base de donnÈes et la mettre dans
			// variable

			String req = "UPDATE commande SET dateLiv = SYSDATE WHERE numCde = "
					+ numCmd;
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
