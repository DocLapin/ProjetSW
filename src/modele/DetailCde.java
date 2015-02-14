package modele;

import java.util.ArrayList;

public class DetailCde {
private Commande cde;
private ArrayList<Produit> pdt = new ArrayList<Produit>();
private String adresseLiv;


public ArrayList<Produit> getPdt() {
	return pdt;
}
public void setPdt(ArrayList<Produit> pdt) {
	this.pdt = pdt;
}
public Commande getCde() {
	return cde;
}
public void setCde(Commande cde) {
	this.cde = cde;
}
public String getAdresseLiv() {
	return adresseLiv;
}
public void setAdresseLiv(String adresseLiv) {
	this.adresseLiv = adresseLiv;
}



}
