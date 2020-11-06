package horaires;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class HoraireTravail extends Horaire {

  public HoraireTravail(int no, int noEmploye, String dateJour,
      String debutMatin, String finMatin, String debutApresMidi,
      String finApresMidi) {
    super(no, noEmploye, dateJour, debutMatin, finMatin, debutApresMidi,
        finApresMidi);
  }

  public float nbrHeuresTravaillees() throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    Date debut = sdf.parse(getDebutMatin());
    Date fin = sdf.parse(getFinMatin());

    int diff = (int) (debut.getTime() - fin.getTime());
    int resu;

    if (diff < 0) {

      resu = -diff;
    }

    else {
      resu = diff;

    }

    float nbHeures = resu / 3600000.0f;

    return nbHeures;

  }

}
