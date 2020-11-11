package personnes;

import misc.PatientException;

public abstract class Personne  {

  // est une superclass

  private int no;
  private String nom;
  private String prenom;
  private String adresse;
  private String dateNaissance;
  private String telephone;
  private String email;
  
  public Personne(String nom) {
	  this.nom = nom;
  }

  public Personne(int no, String nom, String prenom, String adresse,
      String dateNaissance, String telephone, String email)
      throws PatientException {
  
    /*
     * this.no = no; this.nom = nom; this.prenom = prenom; this.adresse =
     * adresse; this.dateNaissance = dateNaissance; this.telephone = telephone;
     * this.email = email;
     */

    if ((nom == null)) {
      throw new PatientException("Nom est null");
    }
    
    
    
    if ((nom.trim().length() > 1) && (prenom.trim().length() > 1)) {
      this.no = no;
      this.nom = nom;
      this.prenom = prenom;
      this.adresse = adresse;
      this.dateNaissance = dateNaissance;
      this.telephone = telephone;
      this.email = email;
    }
    
    else {
      this.no = no;
      throw new PatientException("Nom invalide pour le patient no.:" + no);
    }
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(String dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
 
}
