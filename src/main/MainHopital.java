package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import autres.Immeuble;
import autres.Lit;
import autres.Medicament;
import autres.Ordinateur;
import autres.StockMedicaments;
import horaires.HoraireTravail;
import personnes.Administratif;
import personnes.Infirmier;
import personnes.Medecin;
import personnes.Patient;
import personnes.Personne;
import local.Chambre;
import soins.Operation;
import soins.Soin;
import misc.*;
import autres.Traitement;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class MainHopital {

	

	public static void main(String[] args) throws Exception {
		
		
		
		MainHopital mh = new MainHopital();
		List<Infirmier> infirmiers = mh.retrieveInfirmiers();
	
		
		
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

		// Football
		System.out.println();
		System.out.println("Football");
		System.out.println("========");
		
		
		// news
		Medecin medecin2 = new Medecin("Robert");// 1
		Medecin medecin3 = new Medecin("Bobby");// 2
		Medecin medecin4 = new Medecin("Rockford");// 3
		Administratif administratif1 = new Administratif("Robert");// 4
		Administratif administratif2 = new Administratif("Henri");// 5
		Administratif administratif3 = new Administratif("Zizou");// 6
		Infirmier infirmier1 = new Infirmier("Jojo");// 7
		Infirmier infirmier2 = new Infirmier("Bebert");// 8
		Infirmier infirmier3 = new Infirmier("Chapuisat");// 9
		Medecin medecin5 = new Medecin("Yvan");// 10
		Medecin medecin6 = new Medecin("Vladimir");// 11
		
		//infimier pour database
		Infirmier infirmier4 = new Infirmier(4, "Diaz", "Henri", "rue des Martines 15", "12.04.1993", "0794786523", "hdiaz@gmail.com", "Pédiatrie");
		Infirmier infirmier5 = new Infirmier(5, "Lopez", "Charles", "rue des Bains 22", "12.02.1965", "0797653465", "clopez@gmail.com", "Ophtalmologie");
		
		mh.createInfirmier(infirmier4);
		mh.createInfirmier(infirmier5);
		mh.updateInfirmier(infirmier5);
		mh.deleteInfirmier(infirmier4);
		//retrieve l0infirmier qui a l'ID 3 dans la database
		mh.retrieveInfirmierUnique(3);
		
		
		// création de la liste listeJoueursFoot
		ArrayList<Personne> listeJoueursFoot = new ArrayList<>();
		
		// ajout des instances à la liste listeJoueursFoot
		listeJoueursFoot.add(medecin2);
		listeJoueursFoot.add(medecin3);
		listeJoueursFoot.add(medecin4);
		listeJoueursFoot.add(medecin5);
		listeJoueursFoot.add(medecin6);
		listeJoueursFoot.add(administratif1);
		listeJoueursFoot.add(administratif2);
		listeJoueursFoot.add(administratif3);
		listeJoueursFoot.add(infirmier1);
		listeJoueursFoot.add(infirmier2);
		listeJoueursFoot.add(infirmier3);
		
		// appel de la méthode listeJoueursFoot
		creerEquipeFoot(listeJoueursFoot);
		// Ajout des personnes au tableauMedicaments

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
		System.out.println("Lits :");
		System.out.println("======");
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
		Lit lit20 = new Lit(20, true, true, false);
		Lit lit21 = new Lit(21, true, false, false);

		// ajout des instances Lit à la liste lstLits
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
		lstLits.add(lit21);

		// Creation du dictionnaire des lits pour attribution par 3 listes de lits des lits
		HashMap<String, Set<Lit>> litsChambre = new HashMap<String, Set<Lit>>();

		// Création et ajouts des lits dans la liste litsChambre34
		Set<Lit> litsChambre34 = new HashSet<Lit>();
				litsChambre34.add(lit01);
		litsChambre34.add(lit04);
		litsChambre34.add(lit05);
		litsChambre34.add(lit07);
		litsChambre34.add(lit09);
		litsChambre34.add(lit11);
		litsChambre34.add(lit12);
		litsChambre34.add(lit15);
		litsChambre34.add(lit17);
		litsChambre34.add(lit19);

		// Création et ajouts des lits dans la liste litsChambre19
		Set<Lit> litsChambre19 = new HashSet<Lit>();
		litsChambre19.add(lit02);
		litsChambre19.add(lit06);
		litsChambre19.add(lit10);
		litsChambre19.add(lit13);
		litsChambre19.add(lit16);

		// Création et ajouts des lits dans la liste litsChambre67
		Set<Lit> litsChambre67 = new HashSet<Lit>();
		litsChambre67.add(lit03);
		litsChambre67.add(lit08);
		litsChambre67.add(lit14);
		litsChambre67.add(lit18);
		litsChambre67.add(lit20);

		// ajout des listes litsChambre** dans le dictionnaire litsChambre
		litsChambre.put("34", litsChambre34);
		litsChambre.put("19", litsChambre19);
		litsChambre.put("67", litsChambre67);
			
		System.out.println("affichage des numéros de lits par clé chambre du dictionnaire litsChambre");
		System.out.println("=========================================================================");
		Set<String> numeroChambres = litsChambre.keySet();
		for (String s : numeroChambres) {
			System.out.println(s);
			Set<Lit> lits = litsChambre.get(s);
			for (Lit l : lits) {
				System.out.println("-- " + l.getNo());
			}

		}
		System.out.println();

		// appel de la méthode chercherChambrePourLit pour trouver dans quelle chambre se trouve un lit
		String noLit = "10";
		String noChambre = chuv.chercherChambrePourLit(litsChambre, noLit);

		System.out.println("Où se trouve le lit " + noLit + " ?");
		System.out.println("========================");
		System.out.println("Le lit " + noLit + " se trouve dans la chambre : " + noChambre);
		System.out.println();

		//

		System.out.println("Liste des chambres");
		System.out.println("===================");
		// Displaying details of the map
		System.out.println("Il y a " + litsChambre.size() + " chambre(s) dans le dictionnaire litsChambre.");
		System.out.println("Ce sont les chambres : " + litsChambre.keySet());
		System.out.println();
		
		deplacerLitChambre(litsChambre34, lit11, litsChambre67);
		
		System.out.println("lits par chambre après déplacement lit");
		System.out.println("======================================");
		for (String s : numeroChambres) {
			System.out.println(s);
			Set<Lit> lits = litsChambre.get(s);
			for (Lit l : lits) {
				System.out.println("-- " + l.getNo());
			}
		}
		System.out.println();
		
		System.out.println("Lits qui trainent dans les corridors");
		System.out.println("====================================");
		for (int i = 0; i < lstLits.size(); i++) {

		if (litsChambre19.contains(lstLits.get(i)) || litsChambre34.contains(lstLits.get(i)) || litsChambre67.contains(lstLits.get(i))) {
			//System.out.println("le lit : " + lstLits.get(i).getNo()	+ " est dans une chambre");		
		} else {
			System.out.println("Le lit " + lstLits.get(i).getNo() + " traine dans les corridors");
		}
		
		}
		
		
		
		System.out.println();

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

	// méthode pour déplacer un lit d'une chambre à l'autre
	public static void deplacerLitChambre(Set<Lit> setLitaSupprimer, Lit litaDeplacer, Set<Lit> setLitaAcceuiller) {
		setLitaSupprimer.remove(litaDeplacer);
		setLitaAcceuiller.add(litaDeplacer);

	}

	public static void creerEquipeFoot(ArrayList<Personne> lstPersonnes) {
		// affichage du tableau des joueurs de foot
		System.out.println("Equipe de Foot");
		System.out.println("==============");
		// création du tableau equipe11 avec 11 cases 
		Personne[] equipe11 = new Personne[11];
		// parcourt la liste lstPersonnes et les attribue au tableau equipe11
		for (int i = 0; i < lstPersonnes.size(); i++) {
			equipe11[i] = lstPersonnes.get(i);
		}
		// affiche les valeurs du tableau equipe11
		for (int i = 0; i< equipe11.length; i++) {
			System.out.println(equipe11[i].getNom());
		}
		
		System.out.println("fin de la méthode creerEquipeFoot");
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
		// t1.
		String nomMedicament = new String("Paracétamol");
		// nomMedicament.

	}
	
	
	// méthode pour deleter éléments de la database
	private boolean deleteInfirmier(Infirmier infirmier) {
		Connection connection;
		ResultSet rs = null;
		Statement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
			return resultat;
		}
		
		try {
			// pour interagir avec la base de données
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");         
            stmt = connection.createStatement();
      
            
            String sqlString = "DELETE FROM Hopital.tblInfirmier WHERE email = '" + infirmier.getEmail() +"'";
        			
            
            int nbrModifs = stmt.executeUpdate(sqlString);
            resultat = nbrModifs < 0 ? true : false;
        			
           
            stmt.close();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            
        } 
		
		return resultat;
        				

	}
	
	
	private boolean updateInfirmier(Infirmier infirmier) {
		Connection connection;
		ResultSet rs = null;
		Statement stmt = null;
		boolean resultat = false;
		if (infirmier == null) {
			return resultat;
		}
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");         
            stmt = connection.createStatement();
            
            String sqlString = "UPDATE Hopital.tblInfirmier SET adresse = 'rue des Etuves 55' WHERE email = '" + infirmier.getEmail() +"'";
            //String sqlString = "UPDATE Hopital.tblInfirmier SET adresse = '15 BLVD Tell' WHERE email = " + infirmier.getEmail();
        	// UPDATE `Hopital`.`tblInfirmier` SET `prenom` = 'José' WHERE (`noInfirmier` = '5');	
            
            System.out.println("Sql String : " + sqlString);
            int nbrModifs = stmt.executeUpdate(sqlString);
            resultat = nbrModifs < 0 ? true : false;
        			
            System.out.print("enregistrement réussi ? :" + resultat);
           
            stmt.close();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            
        } 
		
		return resultat;
        				

	}
	//méthode pour insérer dans database
	private boolean createInfirmier(Infirmier infirmier) {
		//variables
		Connection connection;
		ResultSet rs = null;
		Statement stmt = null;
		boolean resultat = false;
		
		if (infirmier == null) {
			return resultat;
		}
		
		try {
			// pour interagir avec la base de données
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");         
            stmt = connection.createStatement();
            
            String sqlString = "INSERT INTO Hopital.tblInfirmier (nom, prenom, adresse, dateNaissance, telephone, email, specialite) " + 
        			"VALUES ('" + infirmier.getNom() + "', '" +
        			infirmier.getPrenom() + "', '" +
        			infirmier.getAdresse() + "', '" +
        			infirmier.getDateNaissance() + "', '" +
        			infirmier.getTelephone() + "', '" +
        			infirmier.getEmail() + "', '" +
        			infirmier.getSpecialite() +"')" ;
            
            int nbrModifs = stmt.executeUpdate(sqlString);
            resultat = nbrModifs < 0 ? true : false;
        			
           
            stmt.close();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            
        } 
		
		return resultat;
        				

	}// méthode pour retriever de la database un infirmier unique
private Infirmier retrieveInfirmierUnique(int noInfirmier) {
		
		Connection connection;
		ResultSet rs = null;
		Statement stmt = null;
		
		
		try {
			// pour interagir avec la base de données
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
            
            stmt = connection.createStatement();
            //execution de la table SQL
            rs = stmt.executeQuery("SELECT * FROM tblInfirmier WHERE noInfirmier = '" + noInfirmier + "'");
            
            
            System.out.println("-----------------------------------------");
           
            
             List<Infirmier> lstInfirmierUnique = new ArrayList<>();
            //tant qu'il y a des suivants dans la les éléments que nous a retournés la database
             while (rs.next())   {

            	System.out.println(rs.getString(2));
            	Infirmier inf = new Infirmier(
            			rs.getInt(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6),
            			rs.getString(7),
            			rs.getString(8));
            	
            	lstInfirmierUnique.add(inf);
            	
             }
 
       	
            System.out.println("-----------------------------------------");
      
            System.out.println("-----------------------------------------");
            
            rs.close();
            stmt.close();
            
            
            System.out.println("Infirmier récupéré depuis la base de données (on est dans la méthode retrieveInfirmierUnique) : " + lstInfirmierUnique.get(0));
            
            return lstInfirmierUnique.get(0);
            
            
            
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            
        } 
		
		return null;

	}
	
	private List<Infirmier> retrieveInfirmiers() {
		
		Connection connection;
		ResultSet rs = null;
		Statement stmt = null;
		List<Infirmier> listeInfirmier = new ArrayList<>();
		
		try {
			// pour interagir avec la base de données
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Hopital?user=javauser" + "&password=javapass");
            
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tblInfirmier");
            
            System.out.println("-----------------------------------------");
            
            //tant qu'il y a des suivants dans la les éléments que nous a retournés la database
            while (rs.next()) {
            	System.out.println(rs.getString(2));
            	Infirmier inf = new Infirmier(
            			rs.getInt(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6),
            			rs.getString(7),
            			rs.getString(8));
            	
            	listeInfirmier.add (inf);
            	
            	}
            System.out.println("-----------------------------------------");
            for (int i = 0 ; i < listeInfirmier.size(); i++) {
        		System.out.print(listeInfirmier.get(i).getNo() + " ");
        		System.out.print(listeInfirmier.get(i).getPrenom() + " ");
        		System.out.print(listeInfirmier.get(i).getNom() + " ");
        		System.out.print(listeInfirmier.get(i).getAdresse() + " ");
        		System.out.print(listeInfirmier.get(i).getDateNaissance() + " ");
        		System.out.print(listeInfirmier.get(i).getEmail() + " ");
        		System.out.println(listeInfirmier.get(i).getSpecialite() + " ");

            }
            // System.out.println(listeInfirmier.size());
            
            
            
            System.out.println("-----------------------------------------");
            
            rs.close();
            stmt.close();
            
        } catch (Exception ex) {
        	ex.printStackTrace();
            
        } 
		
		return listeInfirmier;
		
		
		
	}
	
	// méthode pour trouver dans quelle chambre se trouve un lit
	// avec en premier argument le dictionnaire et en deuxième le numéro de lit
	public String chercherChambrePourLit(HashMap<String, Set<Lit>> chambres, String noLit) {
		
		// assignation de noLit à no après l'avoir returner en  integer
		int no = Integer.parseInt(noLit);
		// recopié de la ligne 379
		Set<String> numeroChambres = chambres.keySet();
		
		for (String s : numeroChambres) {
			System.out.println("affichage du numéro de chambre (affichage de s)" + s);
			System.out.println("affichage du chambres.get(s) " + chambres.get(s));
			Set<Lit> noLits = chambres.get(s);
			for (Lit l : noLits) {
				if (no == l.getNo()) {
					return s;
				}
			}

		}
		return "pas de lit trouvé !";

	}

}
	
	

