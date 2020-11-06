package personnes;

import local.Chambre;
import local.Local;
import autres.Medicament;
import soins.Operation;
import misc.*;

public class Patient extends Personne {

	private Chambre chambre;
	private Local local;
	private Operation operation;
	private Medicament medicament;

	public Patient(int no, String nom, String prenom, String adresse, String dateNaissance, String telephone,
			String email) throws PatientException, AllergieException {
		super(no, nom, prenom, adresse, dateNaissance, telephone, email);

	}
	
	

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	//méthode toString qui override implicitement celle de Object
	
	public String toString() {
		
		return "Numéro : " + super.getNo() + "\n" +
			"Nom : " + super.getNom() +  "\n" +
			"Prénom : " + super.getPrenom() +  "\n" +
			"Adresse : " + super.getAdresse() +  "\n" +
			"Date de naissance : " + super.getDateNaissance() +  "\n" +
			"Téléphone : " + super.getTelephone() +  "\n" +
			"Email : " + super.getEmail();
			
	}

}
