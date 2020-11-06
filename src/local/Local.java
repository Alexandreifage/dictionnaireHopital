package local;

public abstract class Local {
  
  // est une superclass

  private int no;
  private String nom;
  private String genre;
  private int noImmeuble;
  private int etage;
  private int nbrFenetre;
  private int nbrTable;
  private int surface;

  public Local(int no, String nom, String genre, int noImmeuble, int etage,
      int nbrFenetre, int nbrTable, int surface) {
    this.no = no;
    this.nom = nom;
    this.genre = genre;
    this.noImmeuble = noImmeuble;
    this.etage = etage;
    this.nbrFenetre = nbrFenetre;
    this.nbrTable = nbrTable;
    this.surface = surface;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getNoImmeuble() {
    return noImmeuble;
  }

  public void setNoImmeuble(int noImmeuble) {
    this.noImmeuble = noImmeuble;
  }

  public int getEtage() {
    return etage;
  }

  public void setEtage(int etage) {
    this.etage = etage;
  }

  public int getNbrFenetre() {
    return nbrFenetre;
  }

  public void setNbrFenetre(int nbrFenetre) {
    this.nbrFenetre = nbrFenetre;
  }

  public int getNbrTable() {
    return nbrTable;
  }

  public void setNbrTable(int nbrTable) {
    this.nbrTable = nbrTable;
  }

  public int getSurface() {
    return surface;
  }

  public void setSurface(int surface) {
    this.surface = surface;
  }

}
