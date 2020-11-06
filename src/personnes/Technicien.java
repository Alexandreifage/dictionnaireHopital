package personnes;

import misc.PatientException;

public class Technicien extends Personne{

  public Technicien(int no, String nom, String prenom, String adresse,
      String dateNaissance, String telephone, String email) throws PatientException {
    super(no, nom, prenom, adresse, dateNaissance, telephone, email);
    
  }  

}
