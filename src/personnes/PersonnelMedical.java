package personnes;

import misc.PatientException;

public abstract class PersonnelMedical extends Personne {

  // est une superclass

  private String specialite;
  
  public PersonnelMedical(String nom) throws PatientException {
	    super(nom) ;
	    this.specialite = specialite;
	  }

  public PersonnelMedical(int no, String nom, String prenom, String adresse,
      String dateNaissance, String telephone, String email, String specialite) throws PatientException {
    super(no, nom, prenom, adresse, dateNaissance, telephone, email) ;
    this.specialite = specialite;
  }

  public String getSpecialite() {
    return specialite;
  }

  public void setSpecialite(String specialite) {
    this.specialite = specialite;
  }

}
