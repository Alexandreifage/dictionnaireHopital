package misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate { 
  
  public static String DateAControler(String dateAControler) throws ParseException{
    
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  Date dte = sdf.parse(dateAControler);
  sdf = new SimpleDateFormat("EEEE");
  //System.out.println(sdf.format(dte));
    
  return sdf.format(dte) ;
  
 }
  
}
  
  
  
  
  
  

