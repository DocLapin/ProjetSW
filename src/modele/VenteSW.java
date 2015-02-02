package modele;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import NET.webserviceX.www.Currency;
import NET.webserviceX.www.CurrencyConvertorLocator;
import NET.webserviceX.www.CurrencyConvertorSoap;

public class VenteSW {
	private ArrayList<Client> listeClients = new ArrayList<Client>();
	private Catalogue catalogue;

	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	//
	// Connection conn = ConnexionJDBC.connexion();
	// String req = "SELECT * FROM produit p where p.numProd="+ 2;
	// Statement stmt = conn.createStatement();
	// // execu/on de la requete
	// ResultSet res = stmt.executeQuery(req);
	// res.next();
	// System.out.println(res.getString("designation"));
	// }

	// f1
	public double consulterProd(int numeroProd, String monnaie)
			throws ClassNotFoundException, ServiceException, RemoteException,
			IllegalArgumentException {

		double prixConverti;
		String monnaieBase = "EUR";

		Produit prod = catalogue.consulterProd(numeroProd);

		CurrencyConvertorLocator service = new CurrencyConvertorLocator();

		CurrencyConvertorSoap operation = service.getCurrencyConvertorSoap();

		prixConverti = operation.conversionRate(
				Currency.fromString(monnaieBase), Currency.fromString(monnaie))
				* prod.getPrix(); // appel au service web

		return prixConverti;
	}

	// f2
	public Commande nouvelleCommande(String nomClient) throws ClassNotFoundException, SQLException {

		Connection conn = ConnexionJDBC.connexion();

		Client cli = null;
		
		try {

			String req2 = "SELECT * FROM client WHERE nomClient = " + nomClient;
			Statement stmt2 = conn.createStatement();
			// execution de la requete
			ResultSet res2 = stmt2.executeQuery(req2);

			res2.next();

			cli = new Client(nomClient, res2.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// recuperer valeur sequence Commande
		String req = "INSERT INTO commande(numCde, nomClient) VALUES (seq_commande.nextval, "
				+ nomClient + " )";
		Statement stmt = conn.createStatement();
		// execu/on de la requete
		ResultSet res = stmt.executeQuery(req);

		Commande cmd = new Commande(res.getInt("numCde"), cli);
		return cmd;
	}

	// f3
	public DetailCde consulterCommande(int numCmd) throws SQLException,
			ClassNotFoundException {

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

		// créer objet Commande
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

			// chercher la commande dans la base de données et la mettre dans
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
	
	//f6
	public Commande etatLivCommande(int numCde) throws ClassNotFoundException, SQLException {
		
		Connection conn = ConnexionJDBC.connexion();
		
		Commande cmd=null;

		String req = "SELECT * FROM  commande c "
				+ "WHERE c.numCde = " + numCde;
		Statement stmt = conn.createStatement();
		// execu/on de la requete
		ResultSet res = stmt.executeQuery(req);
		
		String req2 = "SELECT * FROM client WHERE nomClient = " + res.getString("nomClient");
		Statement stmt2 = conn.createStatement();
		// execution de la requete
		ResultSet res2 = stmt2.executeQuery(req2);

		res2.next();

		Client cli = new Client(res2.getString("nomClient"), res2.getString("email"));
		cmd=new Commande(res.getInt("numCde"),cli);
		cmd.setDateLiv(res.getDate("dateLiv"));
		
		return cmd;
		
		
		
	}

}
