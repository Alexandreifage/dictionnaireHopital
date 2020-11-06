package horaires;

public abstract class Horaire {

  private int no;
  private int noEmploye;
  private String dateJour;
  private String debutMatin;
  private String finMatin;
  private String debutApresMidi;
  private String finApresMidi;

  public Horaire(int no, int noEmploye, String dateJour, String debutMatin,
      String finMatin, String debutApresMidi, String finApresMidi) {
    this.no = no;
    this.noEmploye = noEmploye;
    this.dateJour = dateJour;
    this.debutMatin = debutMatin;
    this.finMatin = finMatin;
    this.debutApresMidi = debutApresMidi;
    this.finApresMidi = finApresMidi;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getNoEmploye() {
    return noEmploye;
  }

  public void setNoEmploye(int noEmploye) {
    this.noEmploye = noEmploye;
  }

  public String getDateJour() {
    return dateJour;
  }

  public void setDateJour(String dateJour) {
    this.dateJour = dateJour;
  }

  public String getDebutMatin() {
    return debutMatin;
  }

  public void setDebutMatin(String debutMatin) {
    this.debutMatin = debutMatin;
  }

  public String getFinMatin() {
    return finMatin;
  }

  public void setFinMatin(String finMatin) {
    this.finMatin = finMatin;
  }

  public String getDebutApresMidi() {
    return debutApresMidi;
  }

  public void setDebutApresMidi(String debutApresMidi) {
    this.debutApresMidi = debutApresMidi;
  }

  public String getFinApresMidi() {
    return finApresMidi;
  }

  public void setFinApresMidi(String finApresMidi) {
    this.finApresMidi = finApresMidi;
  }

}
