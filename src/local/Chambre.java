package local;

public final class Chambre extends Local {

  private int nbrLits;
  private boolean prive;

  public Chambre(int no, String nom, String genre, int noImmeuble, int etage,
      int nbrFenetre, int nbrTable, int surface,int nbrLits, boolean prive ) {
    super(no, nom, genre, noImmeuble, etage, nbrFenetre, nbrTable, surface);
    this.nbrLits = nbrLits;
    this.prive = prive;
  }

  public int getNbrLits() {
    return nbrLits;
  }

  public void setNbrLits(int nbrLits) {
    this.nbrLits = nbrLits;
  }

  public boolean isPrive() {
    return prive;
  }

  public void setPrive(boolean prive) {
    this.prive = prive;
  }

}
