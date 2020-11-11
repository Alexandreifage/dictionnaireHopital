package personnes;

import misc.PatientException;

public final class Infirmier extends PersonnelMedical {
	
	public Infirmier(String nom) throws PatientException {
		    super(nom);

		  }

  public Infirmier(int no, String nom, String prenom, String adresse,
      String dateNaissance, String telephone, String email, String specialite) throws PatientException {
    super(no, nom, prenom, adresse, dateNaissance, telephone, email, specialite);

  }
  
  
  
  

}
