package autres;

import java.util.ArrayList;
import java.util.List;

import misc.PatientException;

public class StockMedicaments {

	// tableau de medicaments (j'ai du changer en static)
	private List<Medicament> listeMedicaments = new ArrayList<Medicament>();

	public StockMedicaments(Medicament[] listeMedicaments) {
		for (int i = 0; i < listeMedicaments.length; i++) {
			this.listeMedicaments.add(listeMedicaments[i]);
		}
	}
	//afficher les médicaments, donner un médicament

	public StockMedicaments(List<Medicament> listeMedicaments) {
		this.listeMedicaments = listeMedicaments;
	}

	// add médicament (j'ai du changer en static)
	public void addMedicament(Medicament medic) {
		if (medic != null) {
			listeMedicaments.add(medic);
		}
	}

	// pour enlever un Medicament de StockMedicament 
	public void removeMedicament(Medicament medic) {
		for (Medicament med : listeMedicaments) {			
			if (med.getNo() == medic.getNo()) {
				System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
				System.out.println(medic.getNo());
				listeMedicaments.remove(med);
			}
		}
	
	}
	// nombre de médicament qui restent dans la liste
	// j'ai du changer en static
	public int niveauStock() {
		return listeMedicaments.size();
	}
	
	// donne la liste des médicaments (j'ai ajouté et du mettre en static)
	public  String affichageStock() {
		return listeMedicaments.toString();		
	}
	// donne la liste des noms des médicaments (j'ai ajouté et du mettre en static)
		public   List<String> listerNomMedicaments() {
			List<String> nomMedicaments = new ArrayList<String>();
			for (Medicament med : listeMedicaments) {
				if (med == null) {
					
				}
				else {
					nomMedicaments.add(med.getNom());
				}
				
			}
			return nomMedicaments;
		}

}
