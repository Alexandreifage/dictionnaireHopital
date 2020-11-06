package autres;

import java.util.ArrayList;



public class Immeuble {

	private int no;
	private String nom;
	private String adresse;
	private int nbrEtage;

	public Immeuble(int no, String nom, String adresse, int nbrEtage) {
		this.no = no;
		this.nom = nom;
		this.adresse = adresse;
		this.nbrEtage = nbrEtage;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}
	
	

	
		
	

}
