/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Tests;

 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Data.Auto;

/**
 *
 * @author Felix
 */
public class testAuto{
    
 //   private List list;
    
    
    String kennzeichen;
    String marke;
    int sitzplaetze;
    float tagessatz;
    String modell;
    String typ;
    String farbe;
    String maengel;

    
    @Before 
    public void setup(){
        
     kennzeichen = "KM-MN-23";
     marke = "Audi" ;
     sitzplaetze = 5;
     tagessatz = 40;
     modell = "A4";
     typ = "Limousine";
     farbe = "Blau";
     maengel = "Keine MÃ¤ngel";
    
}
  
    
    //zu kurzes Kennzeichen
 /**   @Test
    public void testAnlegen_kfz_kurz() {
        
        kennzeichen="K1";
        Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        String test_erg = test.anlegen();
        String expected = "short_kfz";
        Assert.assertTrue(expected.equals(test_erg));
        setup();
    }
    
    @Test
    public void testAnlegen_kfz_lang() {
        
        kennzeichen="KM-MSS-2341";
        Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        String test_erg = test.anlegen();
        String expected = "long_kfz";
        Assert.assertTrue(expected.equals(test_erg));
        setup();
    } **/
    
//    @Test
//     public void testAnlegen_kfz_content() {
//        
//        List<String> tests = new ArrayList<>(); 
//        tests.add("");
//        tests.add("132");
//        tests.add("a-b-199999");
//        tests.add("abds-a-123");
//        tests.add("A1-AA-12");
//        
//        for (int i = 0; i < tests.size(); i++)
//        {
//        
//        kennzeichen=tests.get(i);
//        Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
//        String test_erg = test.anlegen();
//        String expected = "long_kfz";
//        Assert.assertTrue(expected.equals(test_erg));
//        setup();
//        }
//    }
    
//        List<String> testi = new ArrayList<>(); 
//        t
//        tests.add("132");
//        tests.add("a-b-199999");
//        tests.add("abds-a-123");
//        tests.add("A1-AA-12");
        
    
            
       @Test
     public void testAnlegen_kfz_short() {
        

        
        kennzeichen="A-B";
        String expected = "Das angegebene Kennzeichen ist zu kurz.";
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
       
       @Test
       public void testAnlegen_kfz_long() {
          

          
          kennzeichen="AAB-EIB-134";
          String expected = "Das angegebene Kennzeichen ist zu lang.";
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
       
    
    
        
     @Test
    public void testAnlegen_seats_low() {
        
        
        
        sitzplaetze=0;
        String test_erg = new String();
        String expected = "Die Sitzzahl darf nicht unter 1 liegen.";
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
     
     @Test
     public void testAnlegen_seats_high() {
         
         
         
         sitzplaetze=8;
         String test_erg = new String();
         String expected = "Die Sitzzahl darf nicht ueber 7 liegen.";
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
    
   /**  @Test
     	public void testAnlegen_tagessatz_kommas(){
    	 
    	 tagessatz = (float) 0,123;
         String test_erg = new String();
         String expected = "Der Tagessatz darf nicht mehr als 2 Nachkommastellen haben.";
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
     
     
     //Nullwerte werden bei der Eingabe behandelt und können deshalb nicht getestet werden
     
    @Test  
    public void testAnlegen_tagessatz_punkt(){
   	 
   	 tagessatz = (float) 0.123;
        String test_erg = new String();
        String expected = "Der Tagessatz darf nicht mehr als 2 Nachkommastellen haben.";
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
     
    @Test  
    public void testAnlegen_tagessatz_punktok(){
   	 
   	 tagessatz = (float) 0.23;
        String test_erg = new String();
        String expected = "";
        try{        
        Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
        }
        catch (Exception e)
        {
        	test_erg = e.getMessage();        	
        }
        
        
        Assert.assertTrue(expected.equals(""));
        setup();
   	 }
    /**  Kommawerte werden vorher behandelt und in Punkte geändert
    @Test  
    public void testAnlegen_tagessatz_kommaok(){
   	 
   	 tagessatz = (float) 0,23;
        String test_erg = new String();
        String expected = "";
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
    
    
    @Test
    public void testAnlegen_tagessatz_low() {
        
        
        
    	 tagessatz=-3;
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
   /**  NULL werte werden vorher behandelt und ausgeschlossen, Java wirft eigenen Error - Test entfällt
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
