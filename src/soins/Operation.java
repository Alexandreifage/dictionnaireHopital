package soins;


import misc.ControleDateException;
import misc.TestDate;

public final class Operation extends Soin  {

  public Operation(int no, String dateSoin, String genre, int noPatient,
      int duree) throws Exception {
    super(no, dateSoin, genre, noPatient, duree);       
        
    if (TestDate.DateAControler(dateSoin).equals("samedi") || TestDate.DateAControler(dateSoin).equals("dimanche")) {
      throw new ControleDateException("!! Attention c'est un " + TestDate.DateAControler(dateSoin).toUpperCase());
      //System.out.println("!! Attention c'est un " + TestDate.DateAControler(dateSoin).toUpperCase());
      
    }     
 }
  
}
