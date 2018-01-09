/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.Kunde;

 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Data.Kunde;
/**
 *
 * @author felix
 */
public class testKunde {
    
    
    private int kdID;
    private String name;
    private String vorname;
    private String plz;
    private String strasse;
    private int hausnummer;
    private String wohnort;
    private String telefonnummer;
    private String geburtsdatum;
    private String fKlasse;
    private Kunde testKunde;
    
    @Before
    public void setup(){
       //befuellung mit gueltigen Daten
    
    //KDID wird automatisch fortlaufend vergeben 
    kdID = 2;
    name = "Topp";
    vorname = "Markus";
    plz = "09648";
    strasse = "Bahnhofstrasse";
    hausnummer = 35;
    wohnort = "Mittweede";
    telefonnummer = "011111112222";
    geburtsdatum = "01.01.1990";
    fKlasse = "A2";
    testKunde = new Kunde (kdID, name, vorname, plz,strasse, hausnummer, wohnort, telefonnummer, geburtsdatum, fKlasse);
           
        
    }
    
    /** hier finden die Klassentests statt **/
    /** Test für getkdID, int **/
      @Test
    public void tkunde_get_kdID(){
    
          
        int test_erg = testKunde.getKdID();
               
        
        Assert.assertTrue(test_erg == kdID);
        setup();
   }
    /** Test für getName, String **/
    @Test
    public void tkunde_get_name(){
    
          
        String test_erg = new String(testKunde.getName());
               
        
        Assert.assertTrue(test_erg.equals(name));
        setup();
   }
    
      /** Test für getVorname, String **/
    @Test
    public void tkunde_get_vorname(){
    
          
        String test_erg = new String(testKunde.getVorname());
               
        
        Assert.assertTrue(test_erg.equals(vorname));
        setup();
   }
   
      /** Test für getPLZ, String **/
    @Test
    public void tkunde_get_plz(){
    
          
        String test_erg = new String(testKunde.getPlz());
               
        
        Assert.assertTrue(test_erg.equals(plz));
        setup();
   }
    
        /** Test für getStrasse, String **/
    @Test
    public void tkunde_get_strasse(){
    
          
        String test_erg = new String(testKunde.getStrasse());
               
        
        Assert.assertTrue(test_erg.equals(strasse));
        setup();
   }
    
        /** Test für getHausnummer, Integer **/
    @Test
    public void tkunde_get_hausnummer(){
    
          
        int test_erg = testKunde.getHausnummer();
               
        
        Assert.assertTrue(test_erg == hausnummer);
        setup();
   }
    
    
         /** Test für getWohnort, String **/
    @Test
    public void tkunde_get_wohnort(){
    
          
        String test_erg = new String(testKunde.getWohnort());
               
        
        Assert.assertTrue(test_erg.equals(wohnort));
        setup();
   }
    
         /** Test für getTelefonnummer, String **/
    @Test
    public void tkunde_get_telefonnummer(){
    
          
        String test_erg = new String(testKunde.getTelefonnummer());
               
        
        Assert.assertTrue(test_erg.equals(telefonnummer));
        setup();
   }
    
         /** Test für getGeburtsdaaum, String **/
    @Test
    public void tkunde_get_gebdat(){
    
          
        String test_erg = new String(testKunde.getGeburtsdaaum());
               
        
        Assert.assertTrue(test_erg.equals(geburtsdatum));
        setup();
   }
    
         /** Test für getFKlasse, String **/
    @Test
    public void tkunde_get_fKlasse(){
    
          
        String test_erg = new String(testKunde.getFKlasse());
               
        
        Assert.assertTrue(test_erg.equals(fKlasse));
        setup();
   }
    
}
