package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import autres.Immeuble;
import autres.Lit;
import autres.Medicament;
import autres.Ordinateur;
import autres.StockMedicaments;
import horaires.HoraireTravail;
import personnes.Medecin;
import personnes.Patient;
import local.Chambre;
import soins.Operation;
import soins.Soin;
import misc.*;
import autres.Traitement;

public class MainHopital {

	// Création de tableau
	// déclaration du tableau de médicaments (peut en accepter 5)

	public static void main(String[] args) throws Exception {

		// code Main Alexandre
		/// zzzzttttzzzz

		Medicament[] tableauMedicaments = new Medicament[5];

		// nouveau medecin
		Medecin medecin1 = new Medecin(345, "Schmidt", "Laurent", "Blvd Carl-Vogt 9", "13.5.92", "078 555 66 77",
				"lschmidt@yahoo.com", "ORL");

		// création de la liste de patients ne contenant que des String
		ArrayList<String> patients = new ArrayList<String>();

		// création de la liste de patients contenant les objets
		ArrayList<Patient> patientscomplete = new ArrayList<Patient>();

		// nouveau patient
		Patient patient1 = new Patient(171021, "Martin", "Arthur", "Rue de la Madeleine 4", "14.02.2004",
				"076 323 24 24", "a.martin@ifage.ch");
		patientscomplete.add(patient1);

		// pour ajouter à la liste des patients
		patients.add(patient1.getPrenom() + " " + patient1.getNom());

		// nouveau patient
		Patient patient2 = new Patient(171021, "Duclos", "Serge", "Rue des Oiseaux 9", "09.09.1999", "077 673 67 76",
				"s.duclos@ifage.ch");
		patientscomplete.add(patient2);
		// pour ajouter à la liste des patients
		patients.add(patient2.getPrenom() + " " + patient2.getNom());

		// donne la liste des patients
		System.out.println("Liste des " + patients.size() + " patients :");
		for (String i : patients) {
			System.out.println(i);
		}
		System.out.println("");

		// donne la liste des patients complete
		System.out.println("Liste complète (toString) des " + patientscomplete.size() + " patients :");
		for (int i = 0; i < patientscomplete.size(); i = i + 1) {

			Patient c = patientscomplete.get(i);

			System.out.println(c);
			System.out.println();

		}
		System.out.println("");

		// création de la liste d'immeubles
		ArrayList<String> immeubles = new ArrayList<String>();

		// nouvel immeuble
		Immeuble immeuble1 = new Immeuble(1, "Bâtiment Principal", "34, Rue des Martyrs", 9);
		// pour ajouter à la liste des patients
		immeubles.add(immeuble1.getNo() + " " + immeuble1.getNom() + " " + immeuble1.getAdresse() + " "
				+ immeuble1.getNbrEtage());
		// nouvel immeuble
		Immeuble immeuble2 = new Immeuble(2, "Ophtalmologie", "37, Rue des Martyrs", 2);
		// pour ajouter à la liste des patients
		immeubles.add(immeuble2.getNo() + " " + immeuble2.getNom() + " " + immeuble2.getAdresse() + " "
				+ immeuble2.getNbrEtage());
		// nouvel immeuble
		Immeuble immeuble3 = new Immeuble(3, "Maternité", "7, Rue des Cygognes", 4);
		// pour ajouter à la liste des patients
		immeubles.add(immeuble3.getNo() + " " + immeuble3.getNom() + " " + immeuble3.getAdresse() + " "
				+ immeuble3.getNbrEtage());

		// donne la liste des immeubles
		System.out.println("Liste des " + immeubles.size() + " immeubles :");
		for (String i : immeubles) {
			System.out.println(i);
		}
		System.out.println("");

		// création de la liste de médicaments
		ArrayList<String> medicaments = new ArrayList<String>();

		// nouveau médicament
		Medicament medicament1 = new Medicament(55, "Décaménol", "plein de trucs chimiques", "Galéniforme 3",
				"somnolence", "arachides");
		// pour ajouter à la liste des médicaments
		medicaments.add(medicament1.getNom() + "-> " + medicament1.getAllergie());
		// pour ajouter au tableau des médicaments
		// tableauMedicaments [0] = medicament1.getNom();
		// nouveau médicament
		Medicament medicament2 = new Medicament(35, "Fépalconium", "Co5, E332, KZC", "Galéniforme 4", "démence",
				"lactose");
		// pour ajouter à la liste des médicaments
		medicaments.add(medicament2.getNom() + "-> " + medicament2.getAllergie());
		// nouveau médicament
		Medicament medicament3 = new Medicament(15, "Rochignol", "Klanadorium liquide", "Galéniforme 1",
				"vertiges, nausées", "pollen");
		// pour ajouter à la liste des médicaments
		medicaments.add(medicament3.getNom() + "-> " + medicament3.getAllergie());

		// Ajout des médicaments au tableauMedicaments
		tableauMedicaments[0] = medicament1;
		tableauMedicaments[1] = medicament2;
		tableauMedicaments[2] = medicament3;

		// affichage du tableau des médicaments
		System.out.println("Tableau des médicaments");
		System.out.println("=======================");
		for (int i = 0; i < tableauMedicaments.length; i = i + 1) {
			Medicament m = tableauMedicaments[i];
			System.out.println(m);
		}

		// donne la liste des médicaments
		System.out.println("Liste des médicaments et allérgies:");
		for (String i : medicaments) {
			System.out.println(i);
		}
		System.out.println("");

		Medicament.allergies();

		// Classe StockMedicaments

		StockMedicaments sm = new StockMedicaments(tableauMedicaments);

		// pour ajouter à la liste de la classe StockMedicaments
		sm.addMedicament(medicament1);
		sm.addMedicament(medicament2);
		sm.addMedicament(medicament3);

		System.out.println();
		// Affichage du stock
		System.out.println("Il reste " + sm.niveauStock() + " Médicaments dans le stock qui sont :");
		System.out.println(sm.affichageStock());

		// pour enlever un medicament de la Classe StockMedicament
		sm.removeMedicament(medicament3);

		System.out.println();
		// Affichage du stock
		System.out.println("Il reste " + sm.niveauStock() + " Médicaments dans le stock qui sont :");
		System.out.println();

		System.out.println(sm.affichageStock());

		System.out.println();

		afficherStockMedicaments(sm);

		MainHopital chuv = new MainHopital();

		chuv.afficherStockMedicaments2(sm);

		// zzzztttt

		// nouveau code Alexandre

		System.out.println();
		System.out.println("Ordinateurs");
		System.out.println("===========");
		System.out.println();

		// création tableau ordinateurs
		Ordinateur[] tableauOrdinateurs = new Ordinateur[100];
		// création liste ordinateurs
		ArrayList<Ordinateur> lstOrdinateurs = new ArrayList<Ordinateur>();

		// news ordinateurs
		Ordinateur ordinateur01 = new Ordinateur(7, "MacBookPro", 500, 34, "portable");
		Ordinateur ordinateur02 = new Ordinateur(8, "MacBookPro", 500, 23, "portable");
		Ordinateur ordinateur03 = new Ordinateur(4, "MacBookPro", 500, 44, "portable");
		Ordinateur ordinateur04 = new Ordinateur(10, "MacBookPro", 500, 1, "portable");
		Ordinateur ordinateur05 = new Ordinateur(2, "MacBookPro", 500, 34, "portable");
		Ordinateur ordinateur06 = new Ordinateur(5, "IMac", 250, 34, "fixe");
		Ordinateur ordinateur07 = new Ordinateur(1, "MacBookPro", 500, 34, "portable");
		Ordinateur ordinateur08 = new Ordinateur(3, "IPad", 500, 34, "tablette");
		Ordinateur ordinateur09 = new Ordinateur(9, "MacBookPro", 500, 34, "portable");
		Ordinateur ordinateur10 = new Ordinateur(6, "Ipad", 500, 34, "tablette");

		// ajouts à la liste ordinateurs
		lstOrdinateurs.add(ordinateur01);
		lstOrdinateurs.add(ordinateur02);
		lstOrdinateurs.add(ordinateur03);
		lstOrdinateurs.add(ordinateur04);
		lstOrdinateurs.add(ordinateur05);
		lstOrdinateurs.add(ordinateur06);
		lstOrdinateurs.add(ordinateur07);
		lstOrdinateurs.add(ordinateur08);
		lstOrdinateurs.add(ordinateur09);
		lstOrdinateurs.add(ordinateur10);

		// affichage de la lstOrdinateurs
		for (int i = 0; i < lstOrdinateurs.size(); i = i + 1) {
			System.out.println(lstOrdinateurs.get(i).toString());
			System.out.println();
		}

		// Creation du dictionnaire des ordinateurs
		HashMap<String, Ordinateur> ordinateurs = new HashMap<String, Ordinateur>();

		// ajouter clés et valeurs au dictionnaire
		ordinateurs.put("MacBookPro", ordinateur01);
		ordinateurs.put("IPad", ordinateur08);
		System.out.println();
		System.out.println("dictionnaire ordinateurs");
		System.out.println("====================");
		System.out.println(ordinateur08);
		ordinateurs.put("PT", ordinateur01);
		ordinateurs.put("IM", ordinateur06);
		System.out.println();
		System.out.println("dictionnaire ordinateurs avec clé PT et IM get clé et mémoire");
		System.out.println("==========================================================");
		System.out.println("ordinateur PT, mémoire : " + ordinateurs.get("PT").getMemoire() + " gigas.");
		System.out.println("ordinateur IM, mémoire : " + ordinateurs.get("IM").getMemoire() + " gigas.");

		System.out.println();
		System.out.println("Lits");
		System.out.println("====");
		System.out.println();

		// création liste lits
		ArrayList<Lit> lstLits = new ArrayList<Lit>();

		// news
		Lit lit01 = new Lit(1, true, true, false);
		Lit lit02 = new Lit(2, false, true, false);
		Lit lit03 = new Lit(3, true, true, false);
		Lit lit04 = new Lit(4, true, true, false);
		Lit lit05 = new Lit(5, true, true, false);
		Lit lit06 = new Lit(6, false, true, false);
		Lit lit07 = new Lit(7, true, true, true);
		Lit lit08 = new Lit(8, true, true, true);
		Lit lit09 = new Lit(9, true, true, false);
		Lit lit10 = new Lit(10, false, false, false);
		Lit lit11 = new Lit(11, true, true, false);
		Lit lit12 = new Lit(12, true, true, false);
		Lit lit13 = new Lit(14, false, true, false);
		Lit lit14 = new Lit(15, false, false, false);
		Lit lit15 = new Lit(15, false, true, false);
		Lit lit16 = new Lit(16, false, false, false);
		Lit lit17 = new Lit(17, false, true, false);
		Lit lit18 = new Lit(18, true, true, false);
		Lit lit19 = new Lit(19, false, true, false);
		Lit lit20 = new Lit(10, true, true, false);

		// ajout à la liste lits
		lstLits.add(lit01);
		lstLits.add(lit02);
		lstLits.add(lit03);
		lstLits.add(lit04);
		lstLits.add(lit05);
		lstLits.add(lit06);
		lstLits.add(lit07);
		lstLits.add(lit08);
		lstLits.add(lit09);
		lstLits.add(lit10);
		lstLits.add(lit11);
		lstLits.add(lit12);
		lstLits.add(lit13);
		lstLits.add(lit14);
		lstLits.add(lit15);
		lstLits.add(lit16);
		lstLits.add(lit17);
		lstLits.add(lit18);
		lstLits.add(lit19);
		lstLits.add(lit20);

		// Creation du dictionnaire des lits pour attribution par chambre
		HashMap<String, Lit> litsChambre = new HashMap<String, Lit>();

		litsChambre.put("34", lit01);
		litsChambre.put("19", lit02);
		litsChambre.put("67", lit03);
		litsChambre.put("34", lit04);
		litsChambre.put("34", lit05);
		litsChambre.put("19", lit06);
		litsChambre.put("34", lit07);
		litsChambre.put("67", lit08);
		litsChambre.put("34", lit09);
		litsChambre.put("19", lit10);
		litsChambre.put("34", lit11);
		litsChambre.put("34", lit12);
		litsChambre.put("19", lit13);
		litsChambre.put("67", lit14);
		litsChambre.put("34", lit15);
		litsChambre.put("19", lit16);
		litsChambre.put("34", lit17);
		litsChambre.put("67", lit18);
		litsChambre.put("34", lit19);
		litsChambre.put("67", lit20);

		System.out.println("Lits par type");
		System.out.println("=============");
		

		// affichage par la lstLits du nombre de lits par type

		// lits médicalisés avec barrière enfants
		int nbreLitsMBE = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == true && lstLits.get(i).isEnfant() == true
					&& lstLits.get(i).isMedicalise() == true) {
				nbreLitsMBE = nbreLitsMBE + 1;
			}
		}
		// lits médicalisés sans barrière enfants
		int nbreLitsMsBE = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == false && lstLits.get(i).isEnfant() == true
					&& lstLits.get(i).isMedicalise() == true) {
				nbreLitsMsBE = nbreLitsMsBE + 1;
			}
		}
		// lits médicalisés avec barrière adultes
		int nbreLitsMBA = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == true && lstLits.get(i).isEnfant() == false
					&& lstLits.get(i).isMedicalise() == true) {
				nbreLitsMBA = nbreLitsMBA + 1;
			}
		}
		// lits médicalisés avec barrière adultes
		int nbreLitsMsBA = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == false && lstLits.get(i).isEnfant() == false
					&& lstLits.get(i).isMedicalise() == true) {
				nbreLitsMsBA = nbreLitsMsBA + 1;
			}
		}
		// lits non médicalisés avec barrière enfants
		int nbreLitsNMBE = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == true && lstLits.get(i).isEnfant() == true
					&& lstLits.get(i).isMedicalise() == false) {
				nbreLitsNMBE = nbreLitsNMBE + 1;
			}
		}
		// lits non médicalisés sans barrière enfants
		int nbreLitsNMsBE = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == false && lstLits.get(i).isEnfant() == true
					&& lstLits.get(i).isMedicalise() == false) {
				nbreLitsNMsBE = nbreLitsNMsBE + 1;
			}
		}
		// lits non médicalisés avec barrière adultes
		int nbreLitsNMBA = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == true && lstLits.get(i).isEnfant() == false
					&& lstLits.get(i).isMedicalise() == false) {
				nbreLitsNMBA = nbreLitsNMBA + 1;
			}
		}
		// lits non médicalisés sans barrière adultes
		int nbreLitsNMsBA = 0;
		for (int i = 0; i < lstLits.size(); i = i + 1) {
			if (lstLits.get(i).isBarriere() == false && lstLits.get(i).isEnfant() == false
					&& lstLits.get(i).isMedicalise() == false) {
				nbreLitsNMsBA = nbreLitsNMsBA + 1;
			}
		}

		System.out.println("Médicalisés avec barrière pour enfants     : " + nbreLitsMBE + " lits.");
		System.out.println("Médicalisés sans barrière pour enfants     : " + nbreLitsMsBE + " lits.");
		System.out.println("Médicalisés avec barrière pour adultes     : " + nbreLitsMBA + " lits.");
		System.out.println("Médicalisés sans barrière pour adultes     : " + nbreLitsMsBA + " lits.");
		System.out.println("Non médicalisés avec barrière pour enfants : " + nbreLitsNMBE + " lits.");
		System.out.println("Non médicalisés sans barrière pour enfants : " + nbreLitsNMsBE + " lits.");
		System.out.println("Non médicalisés avec barrière pour adultes : " + nbreLitsNMBA + " lits.");
		System.out.println("Non médicalisés sans barrière pour adultes : " + nbreLitsNMsBA + " lits.");
		System.out.println();
		
		
		// fin nouveau code Alexandre

		// fin code Main Alexandre

		// nouvelle chambre
		Chambre chambre1 = new Chambre(243, "Ocean", "Isolement", 15, 3, 4, 2, 20, 4, false);
		patient1.setChambre(chambre1);

		Operation operation1 = null;

		try {

			operation1 = new Operation(702444, "01/10/2020", "hernie discale", 171021, 24);
			patient1.setOperation(operation1);

		}

		catch (ControleDateException cde) {
			System.out.println("Exception sur la date " + cde.getMessage());
			return;
		}

		finally {
			System.out.println("Taf");

		}

		// new

		Medicament medicament4 = new Medicament(557, "Décameniol", "rhézimonavite", "galénifome", "vertiges",
				"arachides");
		patient2.setMedicament(medicament1);

		System.out.println("Le nouveau/la nouvelle patient(e) s'appelle : " + patient1.getPrenom() + " "
				+ patient1.getNom() + " No.Patient:" + patient1.getNo());
		System.out.println("il/elle est dans la chambre No. : " + patient1.getChambre().getNo() + " "
				+ patient1.getChambre().getNom());
		System.out.println("il/elle va avoir comme op�ration : " + patient1.getOperation().getGenre());
		System.out.println("Vérifier que " + patient2.getPrenom() + " " + patient2.getNom()
				+ " n'est pas allergique aux : " + patient2.getMedicament().getAllergie()
				+ " vu qu'on lui a préscrit du " + patient2.getMedicament().getNom());

		// calcul le nombre d'heures travaill�es
		HoraireTravail ht = new HoraireTravail(1, 240, "01/10/2020", "08:00", "10:15", "13:00", "18:25");
		System.out.println("La durée travaillée est: " + ht.nbrHeuresTravaillees());

		// on redonne des autres valeurs � patient1/chambre1/operation via les setters
		patient1.setNo(171020);
		patient1.setNom("Sonja Widmer");
		patient1.setAdresse("Lausanne");

		chambre1.setNo(204);
		chambre1.setNom("Soleil");

		patient1.setChambre(chambre1);

		operation1.setNo(32720);
		operation1.setGenre("Prothèse du genou");
		operation1.setDateSoin("08/10/2020");

		patient1.setOperation(operation1);

		System.out.println("L'autre patient(e) s'appelle : " + patient1.getNom() + " No Patient: " + patient1.getNo());
		System.out.println("il/elle est dans la chambre No. : " + patient1.getChambre().getNo() + " "
				+ patient1.getChambre().getNom());
		System.out.println("il/elle va avoir comme opération : " + patient1.getOperation().getGenre());

		Patient patient3 = new Patient(171416, "Blanc", "Albert", "Rte de Chavannes 15", "10.11.1975", "079 122 45 78",
				"a.blanc@ifage.ch");

		System.out.println(
				"3éme patient : " + patient3.getPrenom() + " " + patient3.getNom() + " No Patient:" + patient3.getNo());

		try {

			Patient patient4 = new Patient(171500, "a   ", "Artos", "Ch. de Renens 72", "", "", "a@ifage.ch");

			System.out.println("4ème patient (avec Exception) : " + patient4.getPrenom() + " " + patient4.getNom());

		} catch (PatientException pe) {

			System.out.println("Exception:" + pe.getMessage());
			return;
		}

		finally {

			System.out.println("Finally de Exception");

		}

		HoraireTravail ht1 = new HoraireTravail(1, 240, "01/10/2020", "08:00", "10:15", "13:00", "18:25");
		System.out.println("Le nombre de minutes travaillées est: " + ht.nbrHeuresTravaillees());

		System.out.println("fin du programme");

	}
	
	
	
	public static void afficherStockMedicaments(StockMedicaments stock) {
		System.out.println("");
		System.out.println("liste des medicaments");
		System.out.println("=====================");
		if (stock != null) {
			
			for (String i : stock.listerNomMedicaments()) {
				System.out.println(i);
			}
		}
		
		
	}
	
	public void afficherStockMedicaments2(StockMedicaments stock) {
		System.out.println("");
		System.out.println("liste des medicaments");
		System.out.println("=====================");
		if (stock != null) {
			
			for (String i : stock.listerNomMedicaments()) {
				System.out.println(i);
			}
		}		
	}
	
	public void gererTraitements() {
		Traitement t1 = new Traitement(23, 45, 76, 87, 89);
		//t1.
		String nomMedicament = new String("Paracétamol");
		//nomMedicament.
		
		
	}
	

}
