/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.Vertrag;

 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Data.Vertrag;
import java.util.Date;
/**
 *
 * @author felix
 */
public class testVertrag {
    
    
    private int vertragsID;
    private int kdID;
    private String kennzeichen;
    private String zFahrer;
    private Date abholtermin;
    private Date ruecktermin;
    private Date tatAbholtermin;
    private Date tatRuecktermin;
    private Vertrag testvertrag;
    
    @Before
    public void setup(){
       //befuellung mit gueltigen Daten
    
    vertragsID = 3;
    kdID = 2;
    kennzeichen = "I-F-15";
    zFahrer = "Peter";
    abholtermin = new Date(07,01,2018);
    ruecktermin = new Date(17,01,2018);
    tatAbholtermin = new Date(07,01,2018);
    tatRuecktermin = new Date(18,01,2018);
    testvertrag = new Vertrag(vertragsID,kdID,kennzeichen,zFahrer,abholtermin,ruecktermin,tatAbholtermin,tatRuecktermin);
    
    
           
        
    }
    
    /** hier finden die Klassentests statt **/
    /** Test für getVertragsID, int **/
      @Test
    public void tVertrag_get_vertragsID(){
    
          
        int test_erg;
        test_erg = testvertrag.getVertragsID();
               
        
        Assert.assertTrue(test_erg == vertragsID);
        setup();
   }
    
    
     /** Test für getkdID, int **/
      @Test
    public void tVertrag_get_kdID(){
    
          
        int test_erg;
        test_erg = testvertrag.getKundenID();
               
        
        Assert.assertTrue(test_erg == kdID);
        setup();
   }
    
     /** Test für getKennzeichen, String **/
      @Test
    public void tVertrag_get_kennzeichen(){
    
          
        String test_erg = new String(testvertrag.getKennzeichen());
               
        
        Assert.assertTrue(test_erg.equals(kennzeichen) );
        setup();
   }
    
       /** Test für getZFahrer, String **/
      @Test
    public void tVertrag_get_zFahrer(){
    
          
        String test_erg = new String(testvertrag.getZweitfahrer());
               
        
        Assert.assertTrue(test_erg.equals(zFahrer) );
        setup();
   }
    
    
       /** Test für getAbholtermin, Date **/
      @Test
    public void tVertrag_get_abholtermin(){
    
          
        Date test_erg = testvertrag.getAbholtermin();
               
        
        Assert.assertTrue(test_erg.equals(abholtermin) );
        setup();
   }
    
          /** Test für getRueckgabetermin, Date **/
      @Test
    public void tVertrag_get_rueckgabetermin(){
    
          
        Date test_erg = testvertrag.getRueckgabetermin();
               
        
        Assert.assertTrue(test_erg.equals(ruecktermin) );
        setup();
   }
    
          
    
      /** Test für getTatAbholtermin, Date **/
      @Test
    public void tVertrag_get_TatAbholtermin(){
    
          
        Date test_erg = testvertrag.getTatAbholtermin();
               
        
        Assert.assertTrue(test_erg.equals(tatAbholtermin) );
        setup();
   }
    
    /** Test für getTatRueckgabetermin, Date **/
    
    @Test
    public void tVertrag_get_TatRueckgabetermin(){
    
          
        Date test_erg = testvertrag.getTatRueckgabetermin();
               
        
        Assert.assertTrue(test_erg.equals(tatRuecktermin) );
        setup();
   }
    
}
