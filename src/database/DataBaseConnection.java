package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import personnes.Infirmier;

public class DataBaseConnection {
	
	private static String URL_CONNECTION = 
			
			"jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass";

	private static Connection connection;
	//DataBaseConnection db = new DataBaseConnection();
	private static final DataBaseConnection db = new DataBaseConnection();
	
	private DataBaseConnection()
    {
		db.openConnection();
        System.out.println("Construction du db au premier appel");
    }

    public static DataBaseConnection getDb() 
    {
        return db;
    }

    @Override
    public String toString()
    {
       return String.format("Je suis le DataBaseConnection : %s", super.toString());
       
    
    }
	

	
    //importé
  //méthode pour insérer dans database
  	private boolean createInfirmier(Infirmier infirmier) {
  		//variables
  		Connection connection;
  		ResultSet rs = null;
  		Statement stmt = null;
  		boolean resultat = false;
  		
  		if (infirmier == null) {
  			return resultat;
  		}
  		
  		try {
  			// pour interagir avec la base de données
  			Class.forName("com.mysql.cj.jdbc.Driver");
              connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");         
              stmt = connection.createStatement();
              
              String sqlString = "INSERT INTO Hopital.tblInfirmier (nom, prenom, adresse, dateNaissance, telephone, email, specialite) " + 
          			"VALUES ('" + infirmier.getNom() + "', '" +
          			infirmier.getPrenom() + "', '" +
          			infirmier.getAdresse() + "', '" +
          			infirmier.getDateNaissance() + "', '" +
          			infirmier.getTelephone() + "', '" +
          			infirmier.getEmail() + "', '" +
          			infirmier.getSpecialite() +"')" ;
              
              int nbrModifs = stmt.executeUpdate(sqlString);
              resultat = nbrModifs < 0 ? true : false;
          			
             
              stmt.close();
              
          } catch (Exception ex) {
          	ex.printStackTrace();
              
          } 
  		
  		return resultat;
  	}
	// fin importé 
  		
  	
  	// méthode connection
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
