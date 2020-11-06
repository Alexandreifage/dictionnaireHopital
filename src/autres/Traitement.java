package autres;

public class Traitement {

  private int no;
  private int noPatient;
  private int noMedicament;
  private int dose;
  private int duree;

  public Traitement(int no, int noPatient, int noMedicament, int dose, int duree) {
    this.no = no;
    this.noPatient = noPatient;
    this.noMedicament = noMedicament;
    this.dose = dose;
    this.duree = duree;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getNoPatient() {
    return noPatient;
  }

  public void setNoPatient(int noPatient) {
    this.noPatient = noPatient;
  }

  public int getNoMedicament() {
    return noMedicament;
  }

  public void setNoMedicament(int noMedicament) {
    this.noMedicament = noMedicament;
  }

  public int getDose() {
    return dose;
  }

  public void setDose(int dose) {
    this.dose = dose;
  }

  public int getDuree() {
    return duree;
  }

  public void setDuree(int duree) {
    this.duree = duree;
  }

}
