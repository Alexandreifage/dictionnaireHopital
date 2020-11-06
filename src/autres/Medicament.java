package autres;


public class Medicament {

	private int no;
	private String nom;
	private String composition;
	private String formeGalenique;
	private String effetSecondaire;
	private String allergie;
	

	public Medicament(int no, String nom, String composition, String formeGalenique, String effetSecondaire,String allergie){
		this.no = no;
		this.nom = nom;
		this.composition = composition;
		this.formeGalenique = formeGalenique;
		this.effetSecondaire = effetSecondaire;
		this.allergie = allergie;
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

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getFormeGalenique() {
		return formeGalenique;
	}

	public void setFormeGalenique(String formeGalenique) {
		this.formeGalenique = formeGalenique;
	}

	public String getEffetSecondaire() {
		return effetSecondaire;
	}

	public void setEffetSecondaire(String effetSecondaire) {
		this.effetSecondaire = effetSecondaire;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	
	public static void allergies() {
		
		
	}
public String toString() {
		
		return "Numéro : " + this.no + "\n" +
			"Nom : " + this.nom +  "\n" +
			"Composition : " + this.composition +  "\n" +
			"Forme Galénique : " + this.formeGalenique  +  "\n" +
			"Effet secondaire : " + this.effetSecondaire +  "\n" +
			"Allérgie : " + this.allergie +  "\n" ;
			
			
	}

	
	
}
