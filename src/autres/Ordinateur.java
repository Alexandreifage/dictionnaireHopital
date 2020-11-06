package autres;

public class Ordinateur {

  private int no;
  private String nom;
  private int memoire;
  private int noSalle;
  private String genre;

  public Ordinateur(int no, String nom, int memoire, int noSalle, String genre) {
    this.no = no;
    this.nom = nom;
    this.memoire = memoire;
    this.noSalle = noSalle;
    this.genre = genre;

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

  public int getMemoire() {
    return memoire;
  }

  public void setMemoire(int memoire) {
    this.memoire = memoire;
  }

  public int getNoSalle() {
    return noSalle;
  }

  public void setNoSalle(int noSalle) {
    this.noSalle = noSalle;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
  
  public String toString() {
		return  "numéro   : " + this.no + "\n" +
				"nom      : " + this.nom + "\n" +
				"mémoire  : " + this.memoire + " gigas" + "\n" +	
				"salle n° : " + this.noSalle + "\n" +	
				"genre    : " + this.genre;
  }
  
  

}
