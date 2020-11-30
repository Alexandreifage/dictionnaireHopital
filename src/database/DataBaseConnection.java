package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import autres.Lit;
import autres.Medicament;
import autres.Ordinateur;
import personnes.Infirmier;

public class DataBaseConnection {

	private static String URL_CONNECTION =

			"jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass";

	private static Connection connection;
	// DataBaseConnection db = new DataBaseConnection();
	private static final DataBaseConnection db = new DataBaseConnection();

	private DataBaseConnection() {
		db.openConnection();
		System.out.println("Construction du db au premier appel");
	}

	public static DataBaseConnection getDb() {
		return db;
	}

	@Override
	public String toString() {
		return String.format("Je suis le DataBaseConnection : %s", super.toString());

	}

	// méthode connection
	private static Connection openConnection() {
		if (connection == null) {
			// créér la connection

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			} catch (ClassNotFoundException cnfe) {
				connection = null;
			} catch (SQLException sqle) {
				connection = null;
			}
		}
		return connection;

	}

	public boolean createInfirmier(Infirmier infirmier) {
		// variables
		Statement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
			return resultat;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			stmt = connection.createStatement();

			String sqlString = "INSERT INTO Hopital.tblInfirmier (nom, prenom, adresse, dateNaissance, telephone, email, specialite) "
					+ "VALUES ('" + infirmier.getNom() + "', '" + infirmier.getPrenom() + "', '"
					+ infirmier.getAdresse() + "', '" + infirmier.getDateNaissance() + "', '" + infirmier.getTelephone()
					+ "', '" + infirmier.getEmail() + "', '" + infirmier.getSpecialite() + "')";

			int nbrModifs = stmt.executeUpdate(sqlString);
			resultat = nbrModifs < 0 ? true : false;

			stmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return resultat;
	}

	public List<Infirmier> retrieveInfirmiers() {

		ResultSet rs = null;
		Statement stmt = null;
		List<Infirmier> listeInfirmier = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");

			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tblInfirmier");

			System.out.println("-----------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getString(2));
				Infirmier inf = new Infirmier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

				listeInfirmier.add(inf);

			}
			System.out.println();
			System.out.println("Liste d'infirmier de la base de données");
			System.out.println("---------------------------------------");
			for (int i = 0; i < listeInfirmier.size(); i++) {
				System.out.print(listeInfirmier.get(i).getNo() + " ");
				System.out.print(listeInfirmier.get(i).getPrenom() + " ");
				System.out.print(listeInfirmier.get(i).getNom() + " ");
				System.out.print(listeInfirmier.get(i).getAdresse() + " ");
				System.out.print(listeInfirmier.get(i).getDateNaissance() + " ");
				System.out.print(listeInfirmier.get(i).getEmail() + " ");
				System.out.println(listeInfirmier.get(i).getSpecialite() + " ");

			}

			System.out.println("-----------------------------------------");
			System.out.println();

			rs.close();
			stmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return listeInfirmier;

	}

	public boolean updateInfirmier(Infirmier infirmier, String nouvelleAdresse) {

		Statement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
			return resultat;
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			stmt = connection.createStatement();

			String sqlString = "UPDATE Hopital.tblInfirmier SET adresse = '" + nouvelleAdresse + "' WHERE email = '"
					+ infirmier.getEmail() + "'";

			System.out.println("Sql String : " + sqlString);
			int nbrModifs = stmt.executeUpdate(sqlString);
			resultat = nbrModifs > 0 ? true : false;

			System.out.println("update réussi ? :" + resultat);

			stmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return resultat;
	}

	// méthode pour insérer lit dans database
	public boolean createLit(Lit lit) {
		// variables

		Statement stmt = null;
		boolean resultat = false;

		if (lit == null) {
			return resultat;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			stmt = connection.createStatement();

			String sqlString = "INSERT INTO Hopital.tblLits (medicalise, barriere, enfant) " + "VALUES ('"
					+ convertBooleanToInt(lit.isMedicalise()) + "', '" + convertBooleanToInt(lit.isBarriere()) + "', '"
					+ convertBooleanToInt(lit.isEnfant()) + "')";

			int nbrModifs = stmt.executeUpdate(sqlString);
			resultat = nbrModifs < 0 ? true : false;

			stmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return resultat;

	}

	// méthode pour insérer médicament dans database
	public boolean createMedicament(Medicament medicament) {
		// variables
		Statement stmt = null;
		boolean resultat = false;

		if (medicament == null) {
			return resultat;
		}
		try {
			// pour interagir avec la base de données
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			stmt = connection.createStatement();

			String sqlString = "INSERT INTO Hopital.tblMedicament (nom, composition, formeGalenique, effetSecondaire, allergie) "
					+ "VALUES ('" + medicament.getNom() + "', '" + medicament.getComposition() + "', '"
					+ medicament.getFormeGalenique() + "', '" + medicament.getEffetSecondaire() + "', '"
					+ medicament.getAllergie() + "')";
			System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			System.out.println(sqlString);
			int nbrModifs = stmt.executeUpdate(sqlString);
			resultat = nbrModifs < 0 ? true : false;

			stmt.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultat;
	}
	
	/***************************
	 * VIA STORED PROCEDURES SQL
	 * *************************
	 */

	public boolean createInfirmierProcedureSQL(Infirmier infirmier) {

		CallableStatement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");

			String sqlString = "{call addInfirmier (?, ?, ?, ?, ?, ?, ?)}";
			stmt = connection.prepareCall(sqlString);
			stmt.setString(1, infirmier.getNom());
			stmt.setString(2, infirmier.getPrenom());
			stmt.setString(3, infirmier.getAdresse());
			stmt.setString(4, infirmier.getDateNaissance());
			stmt.setString(5, infirmier.getTelephone());
			stmt.setString(6, infirmier.getEmail());
			stmt.setString(7, infirmier.getSpecialite());

			resultat = stmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("Enregistrement de l'infirmier " + infirmier.getNom() + " réussi dans SQL");

		return resultat;
	}
	
	public boolean effacerInfirmierProcedureSQL(Infirmier infirmier) {

		boolean resultat = false;
		CallableStatement stmt = null;
		try {

			// STEP 4: Execute a query mySQL
			System.out.println("Creating statement...");
			// ici
			String sql = "{call deleteInfirmierParEmail (?)}";
			stmt = connection.prepareCall(sql);
			stmt.setString(1, infirmier.getEmail());
			// Use execute method to run stored procedure.
			System.out.println("Executing stored procedure...");
			resultat = stmt.execute();

			stmt.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}

		}
		System.out.println("Goodbye!");

		return resultat;
	}

	
	public boolean updateInfirmierProcedureSQL(Infirmier infirmier, String nouvelleAdresse) {

		// CallableStatement utilisé lorsqu'on a besoin de fournir des paramètres à une procédure sql
		CallableStatement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
			return resultat;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// fixe
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			// nbr de point d'interrogations = nbre de variables données en paramètres à la méthode SQL
			String sqlString = "{call updateInfirmierParEmail (?, ?)}";
			// Préparation de la requête
			stmt = connection.prepareCall(sqlString);
			stmt.setString(1, infirmier.getEmail());
			stmt.setString(2, nouvelleAdresse);
			System.out.println();
			System.out.println("---------->>>>infirmier appelé par updateInfirmierParEmail " + infirmier.getEmail() );
			System.out.println("---------->>>>SqlString " + sqlString );

			resultat = stmt.execute();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		
		
		infirmier.setAdresse(nouvelleAdresse);
		System.out.println("---------->>>>update de l'adresse de l'infirmier: " + infirmier.getAdresse());
		System.out.println();

		return resultat;
	}
	
	public List<Infirmier> retrieveInfirmierProcedureSQL() {
		
		// mise à zéro du résultat de la requête SQL
		ResultSet rs = null;
		// mise à zéro de la variable stmt qui appartient à la classe Statement qui permet d'exécuter des requêtes SQL
		Statement stmt = null;
		// Création de la liste
		List<Infirmier> listeInfirmier = new ArrayList<>();
		
		

		try {
			// procédure de connection
			Class.forName("com.mysql.cj.jdbc.Driver");// fixe
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
			// new stmt
			stmt = connection.createStatement();
			
			// dans la variable String sqlString on met le string : {call getAllInfirmiers ()}
			String sqlString = "{call getAllInfirmiers ()}";
			// on exécute la requête stockée dans sqlString puis on enregistre le résultat 
			// (tous les infirmiers présents dans la base de données) dans rs
			rs = stmt.executeQuery(sqlString);

			System.out.println("-----------------------------------------");
			// pour parcourir rs 
			while (rs.next()) {
				// création des new
				Infirmier inf = new Infirmier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));

				listeInfirmier.add(inf);

			}
			System.out.println();
			System.out.println("Liste d'infirmier de la base de données via Stored Procedure SQL");
			System.out.println("----------------------------------------------------------------");
			for (int i = 0; i < listeInfirmier.size(); i++) {
				System.out.print(listeInfirmier.get(i).getNo() + " ");
				System.out.print(listeInfirmier.get(i).getPrenom() + " ");
				System.out.print(listeInfirmier.get(i).getNom() + " ");
				System.out.print(listeInfirmier.get(i).getAdresse() + " ");
				System.out.print(listeInfirmier.get(i).getDateNaissance() + " ");
				System.out.print(listeInfirmier.get(i).getEmail() + " ");
				System.out.println(listeInfirmier.get(i).getSpecialite() + " ");

			}

			System.out.println("-----------------------------------------");
			System.out.println();

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("");

		return listeInfirmier;
	}
	
	public boolean createMedicamentProcedureSQL(Medicament medicament) {

		CallableStatement stmt = null;
		boolean resultat = false;
		if (medicament == null) {
			return resultat;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");

			String sqlString = "{call addMedicament (?, ?, ?, ?, ?)}";
			stmt = connection.prepareCall(sqlString);
			stmt.setString(1, medicament.getNom());
			stmt.setString(2, medicament.getComposition());
			stmt.setString(3, medicament.getFormeGalenique());
			stmt.setString(4, medicament.getEffetSecondaire());
			stmt.setString(5, medicament.getAllergie());
			
			resultat = stmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("Enregistrement du medicament " + medicament.getNom() + " réussi dans SQL");

		return resultat;
	}
	public boolean createOrdinateurProcedureSQL(Ordinateur ordinateur) {

		CallableStatement stmt = null;
		boolean resultat = false;
		if (ordinateur == null) {
			return resultat;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");

			String sqlString = "{call addOrdinateur (?, ?, ?, ?)}";
			stmt = connection.prepareCall(sqlString);
			stmt.setString(1, ordinateur.getNom());
			stmt.setInt(2, ordinateur.getNoSalle());
			stmt.setString(3, ordinateur.getGenre());
			stmt.setInt(4, ordinateur.getMemoire());
			
			resultat = stmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("Enregistrement du computer " + ordinateur.getNom() + " n° " +ordinateur.getNo()+ " réussi dans SQL");

		return resultat;
	}
	
	public boolean createLitProcedureSQL(Lit lit) {

		CallableStatement stmt = null;
		boolean resultat = false;

		if (lit == null) {
			return resultat;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");

			String sqlString = "{call addLit (?, ?, ?)}";
			stmt = connection.prepareCall(sqlString);
			stmt.setInt(1, convertBooleanToInt(lit.isMedicalise()));
			stmt.setInt(2, convertBooleanToInt(lit.isBarriere()));
			stmt.setInt(3, convertBooleanToInt(lit.isEnfant()));

			resultat = stmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}
		System.out.println("Enregistrement du lit n° " + lit.getNo() + " réussi dans SQL");

		return resultat;

	}

	private int convertBooleanToInt(boolean booleanToConvert) {
		if (booleanToConvert) {
			return 1;
		} else {
			return 0;

		}
	}

}
