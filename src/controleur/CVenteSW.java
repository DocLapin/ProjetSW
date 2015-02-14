package controleur;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import modele.*;

public class CVenteSW extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VenteSW modeleVenteSW = new VenteSW();

	public void service(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		// identifier la demande

		String demande = req.getParameter("op");

		// consulter produit
		if (demande.equals("f1")) {

			// récupérer les paramètres de la demande
			int numProd = Integer.parseInt(req.getParameter("numProd"));
			String monnaie = req.getParameter("monnaie");
		
			double res;
			// Transmettre la demande au modèle
			try {
				res = (Double) modeleVenteSW.consulterProd(numProd, monnaie.toUpperCase());
			} catch (Exception e) {
				res = 0;
			}

			// Transmettre le résultat à la page JSP consulterProd
			req.setAttribute("prixConverti", res);
			RequestDispatcher d = req
					.getRequestDispatcher("/vue/ConsulterProd.jsp");
			d.forward(req, response);
		}

		// nouvelle commande
		else if (demande.equals("f2")) {

			// récupérer les paramètres de la demande
			String nomClient = req.getParameter("nomClient");

			Commande res;
			// Transmettre la demande au modèle
			try {
				res = modeleVenteSW.nouvelleCommande(nomClient);
			} catch (Exception e) {
				res = null;
			}

			// Transmettre le résultat à la page JSP nouvelleCommande
			req.setAttribute("nouvCommande", res);
			RequestDispatcher d = req
					.getRequestDispatcher("/vue/NouvelleCommande.jsp");
			d.forward(req, response);
		}

		// consulterCommande
		else if (demande.equals("f3")) {

			// récupérer les paramètres de la demande
			int numCmd = Integer.parseInt(req.getParameter("numCmd"));

			DetailCde res;
			// Transmettre la demande au modèle
			try {
				res = modeleVenteSW.consulterCommande(numCmd);
			} catch (Exception e) {
				res = null;
			}

			// Transmettre le résultat à la page JSP ConsulterCommande
			req.setAttribute("commandeChoisie", res);
			RequestDispatcher d = req
					.getRequestDispatcher("/vue/ConsulterCommande.jsp");
			d.forward(req, response);
		}

		// enregistrer livraison commande
		else if (demande.equals("f5")) {

			// récupérer les paramètres de la demande
			int numCmd = Integer.parseInt(req.getParameter("numCmd"));

			boolean res;
			// Transmettre la demande au modèle
			try {
				res = modeleVenteSW.enregistrerLivCmd(numCmd);
			} catch (Exception e) {
				res = false;
			}

			// Transmettre le résultat à la page JSP livCommande
			req.setAttribute("resultatLiv", res);
			RequestDispatcher d = req
					.getRequestDispatcher("/vue/livCommande.jsp");
			d.forward(req, response);
		}

		// vérifier etat livraison
		else if (demande.equals("f6")) {

			// récupérer les paramètres de la demande
			int numCmd = Integer.parseInt(req.getParameter("numCmd"));

			Commande res;
			// Transmettre la demande au modèle
			try {
				res = modeleVenteSW.etatLivCommande(numCmd);
			} catch (Exception e) {
				res = null;
			}

			// Transmettre le résultat à la page JSP etatLiv
			req.setAttribute("commandeChoisie", res);
			RequestDispatcher d = req.getRequestDispatcher("/vue/etatLiv.jsp");
			d.forward(req, response);
		}

	}
}