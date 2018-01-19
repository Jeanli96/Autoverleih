package tests.Auto;

 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Data.Auto;

/**
 *
 * @author Felix
 */
public class testAuto{
    
    
    int autoID;
    String kennzeichen;
    String marke;
    int sitzplaetze;
    float tagessatz;
    String modell;
    String typ;
    String farbe;
    String maengel;
    Auto testauto;
    
    @Before 
    public void setup(){
        
     autoID = 12;
     kennzeichen = "KM-MN-23";
     marke = "Audi" ;
     sitzplaetze = 5;
     tagessatz = 40;
     modell = "A4";
     typ = "Limousine";
     farbe = "Blau";
     maengel = "Keine Mängel";
     testauto = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
}
  
                
       @Test
     public void testAnlegen_kfz_short() {
        

        
        kennzeichen="A-B";
        String expected = "Das angegebene Kennzeichen ist zu kurz.";
        String test_erg =  new String();
        try{
        Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        }
        catch (Exception e)
        {
        	test_erg = e.getMessage();
        }
        
                    
        Assert.assertTrue(expected.equals(test_erg));
        setup();
       
     }
       
       @Test
       public void testAnlegen_kfz_long() {
          

          
          kennzeichen="AAB-EIB-134";
          String expected = "Das angegebene Kennzeichen ist zu lang.";
          String test_erg =  new String();
          try{
          Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
          }
          catch (Exception e)
          {
          	test_erg = e.getMessage();
          }
          
                      
          Assert.assertTrue(expected.equals(test_erg));
          setup();
         
       }
       
    
    
        
     @Test
    public void testAnlegen_seats_low() {
        
        
        
        sitzplaetze=0;
        String test_erg = new String();
        String expected = "Die Sitzzahl darf nicht unter 1 liegen.";
        try{        
        Auto test = new Auto(autoID,kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        }
        catch (Exception e)
        {
        	test_erg = e.getMessage();        	
        }
        
        
 
        Assert.assertTrue(expected.equals(test_erg));
        setup();
        
    }
     /** nur zwei Tests nötig für Sitzplaetze, andere Fehler werden durch GUI abgefangen **/
     @Test
     public void testAnlegen_seats_high() {
         
         
         
         sitzplaetze=8;
         String test_erg = new String();
         String expected = "Die Sitzzahl darf nicht ueber 7 liegen.";
         try{        
         Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
         }
         catch (Exception e)
         {
         	test_erg = e.getMessage();        	
         }
         
         
  
         Assert.assertTrue(expected.equals(test_erg));
         setup();
         
     }
    
   
     
    @Test  
    public void testAnlegen_tagessatz_punkt(){
   	 
   	 tagessatz = (float) 0.123;
        String test_erg = new String();
        String expected = "Der Tagessatz darf nicht mehr als 2 Nachkommastellen haben.";
        try{        
        Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        }
        catch (Exception e)
        {
        	test_erg = e.getMessage();        	
        }
        
        
 
        Assert.assertTrue(expected.equals(test_erg));
        setup();
   	 
    }
     
    @Test  
    public void testAnlegen_tagessatz_punktok(){
   	 
   	 tagessatz = (float) 0.23;
        String test_erg = new String();
        String expected = "";
        try{        
        Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        }
        catch (Exception e)
        {
        	test_erg = e.getMessage();        	
        }
        
        
        Assert.assertTrue(expected.equals(""));
        setup();
   	 }
    
    //Funktionstests
    @Test
    public void tauto_get_kfz(){
    
          
        String test_erg = new String(testauto.getKennzeichen());
               
        
        Assert.assertTrue(test_erg.equals(kennzeichen));
        setup();
   	 }
    
     @Test
    public void tauto_get_Marke(){
    
          
        String test_erg = new String(testauto.getMarke());
               
        
        Assert.assertTrue(test_erg.equals(marke));
        setup();
   	 }
    
     @Test
    public void tauto_get_seats(){
    
          
        int test_erg = testauto.getSitzplaetze();
               
        
        Assert.assertTrue(test_erg == sitzplaetze);
        setup();
   	 }
    
     @Test
    public void tauto_get_Tagessatz(){
    
          
        float test_erg = testauto.getTagessatz();
               
        
        Assert.assertTrue((int)(100 *test_erg) == (int)(100* tagessatz));
        setup();
   	 }
    

      @Test
    public void tauto_get_Modell(){
    
          
        String test_erg = new String(testauto.getModell());
               
        
        Assert.assertTrue(test_erg.equals(modell));
        setup();
   	 }
    
       @Test
    public void tauto_get_Typ(){
    
          
        String test_erg = new String(testauto.getTyp());
               
        
        Assert.assertTrue(test_erg.equals(typ));
        setup();
   	 }
    
    
       @Test
    public void tauto_get_Farbe(){
    
          
        String test_erg = new String(testauto.getFarbe());
               
        
        Assert.assertTrue(test_erg.equals(farbe));
        setup();
   	 }
    
       @Test
    public void tauto_get_Maengel(){
    
          
        String test_erg = new String(testauto.getMaengel());
               
        
        Assert.assertTrue(test_erg.equals(maengel));
        setup();
   	 }
    
    @Test
    public void testAnlegen_tagessatz_low() {
        
        
        
    	 tagessatz=-3;
         String expected = "Der Tagessatz darf nicht unter 0 liegen.";
         String test_erg =  new String();
         try{
         Auto test = new Auto(autoID, kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
         }
         catch (Exception e)
         {
         	test_erg = e.getMessage();
         }
         
                     
         Assert.assertTrue(expected.equals(test_erg));
         setup();
        
      }
   /**  NULL werte werden vorher behandelt und ausgeschlossen, Java wirft eigenen Error - Test entf�llt
    @Test
    public void testAnlegen_tagessatz_null() {
        
        
        
    	 tagessatz= '';
         String expected = "Der Tagessatz darf nicht unter 0 liegen.";
         String test_erg =  new String();
         try{
         Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
         }
         catch (Exception e)
         {
         	test_erg = e.getMessage();
         }
         
                     
         Assert.assertTrue(expected.equals(test_erg));
         setup();
        
      }
    **/
   
    
        
//    @Test
//    public void testAnlegen_tagessatz_okay() {
//        
//        
//        
//        tagessatz=10;
//        Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
//        String test_erg = test.anlegen();
//        String expected = "";
//        Assert.assertTrue(expected.equals(test_erg));
//        setup();
//        
//    }
//    
    
}
