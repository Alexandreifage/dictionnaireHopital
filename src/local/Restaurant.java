package local;

public class Restaurant extends Local {

  private int noResponsable;
  private String responsable;

  public Restaurant(int no, String nom, String genre, int noImmeuble,
      int etage, int nbrFenetre, int nbrTable, int surface, int noResponsable,
      String responsable) {
    super(no, nom, genre, noImmeuble, etage, nbrFenetre, nbrTable, surface);
    this.noResponsable = noResponsable;
    this.responsable = responsable;
  }

  public int getNoResponsable() {
    return noResponsable;
  }

  public void setNoResponsable(int noResponsable) {
    this.noResponsable = noResponsable;
  }

  public String getResponsable() {
    return responsable;
  }

  public void setResponsable(String responsable) {
    this.responsable = responsable;
  }

}
