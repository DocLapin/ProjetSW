package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Catalogue {
	private ArrayList<Produit> listeProduits = new ArrayList<Produit>();

	public Produit consulterProd(int num) throws ClassNotFoundException {

		if (initialiserCatalogue()) {

			for (Produit produit : listeProduits) {
				if (produit.getNumProd() == num)
					return produit;

			}

		}
		
		return null;

	}

	public boolean initialiserCatalogue() throws ClassNotFoundException {

		try {
			Connection conn = ConnexionJDBC.connexion();

			String req = "SELECT * FROM produit";
			Statement stmt = conn.createStatement();
			// execution de la requete
			ResultSet res = stmt.executeQuery(req);

			while (res.next()) {

				listeProduits.add(new Produit(res.getInt("numProd"), res
						.getString("designation"), res.getDouble("prix")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
