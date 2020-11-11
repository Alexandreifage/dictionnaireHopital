package personnes;

import misc.PatientException;

public class Administratif extends Personne {

  private String service;
  private String specialite;
  
  public Administratif(String nom) throws PatientException {
	    super(nom);
  }

  public Administratif(int no, String nom, String prenom, String adresse,
      String dateNaissance, String telephone, String email, String service,
      String specialite) throws PatientException {
    super(no, nom, prenom, adresse, dateNaissance, telephone, email);
    this.service = service;
    this.specialite = specialite;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getSpecialite() {
    return specialite;
  }

  public void setSpecialite(String specialite) {
    this.specialite = specialite;
  }

}
