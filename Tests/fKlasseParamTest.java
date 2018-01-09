package tests.Kunde;



	import static org.junit.Assert.assertEquals;
	import Data.Kunde;
	import java.util.Arrays;
	import java.util.Collection;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.junit.runners.Parameterized;
	import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class fKlasseParamTest{
            
           private int kdID = 2;
           String name = "Topp";
           String vorname ="Markus" ;
           String plz = "09648";
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort = "Dresden";
           String telefonnummer = "01747589452";
           String geburtsdatum = "12.02.1991";
           String fKlasse;

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"AM", ""}, {"A1", ""}, {"A2", ""}, {"A", ""}, {"B", ""}, {"BF17", ""}, {"B96", ""}, {"BE", ""}, {"C1", ""}, {"C", ""}, {"CE", ""}, {"D1", ""},
                {"D1E", ""}, {"D", ""}, {"DE", ""}, {"T", ""}, {"L", ""}, {"AMA", "Die Führerscheinklasse ist keine gültige Klasse."}, {"AM A1", ""}, {"", "Die Führerscheinklasse ist keine gültige Klasse."},
                {"AM", ""}, {"AM A1 A2 A B BF17 B96 BE C1 C CE D1 D1E", ""}
            
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public fKlasseParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                fKlasse = fInput;
	    	String out = new String();
	    	try{
	    		
                        Kunde test = new Kunde(kdID, name, vorname, plz, strasse, hausnummer, wohnort, telefonnummer, geburtsdatum, fKlasse);
        	}
	    	catch (Exception e){
	    		out = e.getMessage();
	    	}
	    	
	        assertEquals(fExpected, out );
	        fInput= "";
	        fExpected = "";
	    }
	}
	

