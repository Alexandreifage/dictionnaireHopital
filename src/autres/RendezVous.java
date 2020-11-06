package autres;

public class RendezVous {

  private int no;
  private String dateRDV;
  private String heureRDV;
  private int noPatient;
  private int noImmeuble;
  private int noService;
  private int noMedecin;

  public RendezVous(int no, String dateRDV, String heureRDV, int noPatient,
      int noImmeuble, int noService, int noMedecin) {
    this.no = no;
    this.dateRDV = dateRDV;
    this.heureRDV = heureRDV;
    this.noPatient = noPatient;
    this.noImmeuble = noImmeuble;
    this.noService = noService;
    this.noMedecin = noMedecin;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getDateRDV() {
    return dateRDV;
  }

  public void setDateRDV(String dateRDV) {
    this.dateRDV = dateRDV;
  }

  public String getHeureRDV() {
    return heureRDV;
  }

  public void setHeureRDV(String heureRDV) {
    this.heureRDV = heureRDV;
  }

  public int getNoPatient() {
    return noPatient;
  }

  public void setNoPatient(int noPatient) {
    this.noPatient = noPatient;
  }

  public int getNoImmeuble() {
    return noImmeuble;
  }

  public void setNoImmeuble(int noImmeuble) {
    this.noImmeuble = noImmeuble;
  }

  public int getNoService() {
    return noService;
  }

  public void setNoService(int noService) {
    this.noService = noService;
  }

  public int getNoMedecin() {
    return noMedecin;
  }

  public void setNoMedecin(int noMedecin) {
    this.noMedecin = noMedecin;
  }

}
