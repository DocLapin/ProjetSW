package modele;
import java.sql.Date;


public class Commande {

private int numcde;
private Client client;
private Date dateLiv;
private String etatCmd;

public Commande(int numcde, Client client) {
	super();
	this.numcde = numcde;
	this.client = client;
	
	boolean result = this.client.nouvelleCmdClient(this);
}


public int getNumcde() {
	return numcde;
}
public void setNumcde(int numcde) {
	this.numcde = numcde;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Date getDateLiv() {
	return dateLiv;
}
public void setDateLiv(Date dateLiv) {
	this.dateLiv = dateLiv;
}

}
