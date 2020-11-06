package soins;

public abstract class Soin  {

  // est une superclass

  private int no;
  private String dateSoin;
  private String genre;
  private int noPatient;
  private int duree;

  public Soin(int no, String dateSoin, String genre, int noPatient, int duree)  {
    this.no = no;
    this.dateSoin = dateSoin;
    this.genre = genre;
    this.noPatient = noPatient;
    this.duree = duree;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getDateSoin() {
    return dateSoin;
  }

  public void setDateSoin(String dateSoin) {
    this.dateSoin = dateSoin;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getNoPatient() {
    return noPatient;
  }

  public void setNoPatient(int noPatient) {
    this.noPatient = noPatient;
  }

  public int getDuree() {
    return duree;
  }

  public void setDuree(int duree) {
    this.duree = duree;
  }

}
