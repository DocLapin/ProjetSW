package modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionJDBC {
	
	public static Connection connexion() throws SQLException, ClassNotFoundException {
		//enregistrer le pilote
		Class.forName("oracle.jdbc.OracleDriver");
		//creer la connexion
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","CONEJOS","CONEJOS"); // "jdbc:oracle:thin:@vs-oracle2:1521:orcl","CONEJOS","CONEJOS"
		//creer unStatement pour une requête sta/que
		return conn;
	}
	
	/*
	 * String req = "SELECT idpers, nompers FROM personnel";
		Statement stmt = conn.createStatement();
		//execu/on de la requete
		ResultSet res = stmt.executeQuery(req);
	*/
	
	
}
