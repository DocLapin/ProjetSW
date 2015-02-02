package modele;
public class Produit {
	
	public Produit(int numProd, String designation, double prix) {
		super();
		this.numProd = numProd;
		this.designation = designation;
		this.prix = prix;
	}


	private int numProd;
	private String designation;
	private double prix;

	public int getNumProd() {
		return numProd;
	}

	public void setNumProd(int numProd) {
		this.numProd = numProd;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

//	public void consulterProd(int num) {
//		
//	}
}
