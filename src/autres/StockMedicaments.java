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

	// pour enlever un Medicament de StockMedicament (j'ai du changer en static)
	public  Medicament removeMedicament(Medicament medic) throws PatientException {
		int position = -1;
		for (Medicament med : listeMedicaments) {
			position += 1;
			if (med.getNo() == medic.getNo()) {
				return listeMedicaments.remove(position);
			}
		}
	// return listeMedicaments.remove(medic);
	// return un oui non si ça c'est bien passé ou non
		throw new PatientException("Médicament introuvable");
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
