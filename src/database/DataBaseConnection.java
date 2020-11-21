package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import personnes.Infirmier;

public class DataBaseConnection {
	
	private static String URL_CONNECTION = 
			
			"jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass";

	private static Connection connection;
	DataBaseConnection db = new DataBaseConnection();
	
	
	//constructeur
	private DataBaseConnection() {
		
	}
	
	
	private static Connection openConnection() {
		if(connection == null) {
			//créér la connection
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");  
				//remplacer ces catchs, pas bons...
			}catch (ClassNotFoundException cnfe){
				connection = null;
			}catch (SQLException sqle) {
				connection = null;
			}
		}
		return connection ;
		
	}
/*	
	public static DataBaseConnection getInstance() {
		if (db == null) {
			db = new DataBaseConnection();
		}
	}
	
	//méthode
	public List<Infirmier>  listerInfirmier() {
		//code pour aller lire les infirmiers dans workbench
		return true;
	}
	
	//méthode
	public boolean ajouterInfirmier(Infirmier infirmier) {
		////code pour aller ajouter les infirmiers dans workbench
		return true;
	}
	//méthode
	public boolean effacerInfirmier(Infirmier infirmier) {
	    // code pour aller effacer les infirmiers dans workbench
		// DELETE FROM tblInfirmier WHERE noInfirmier = inf.getNo();
		return true;
		}
	
	public boolean mettreAJourInfirmier (Infirmier infirmier) {
		// UPDATE tblInfirmier SET nom = inf.getNom() WHERE noInfirmier = inf.getNom()
		return true;
	}
	*/
	
}
