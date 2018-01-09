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
	public class WohnortParamTest{
            
           private int kdID = 2;
           String name = "Topp";
           String vorname = "Markus";
           String plz = "01689";
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort;
           String telefonnummer = "01747589452";
           String geburtsdatum = "12.02.1991";
           String fKlasse = "A2";

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"Hauptstrasse", ""}, {"1Strasse", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."}, {"Hau&tstrasse", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."},
                {"Hauptstraße", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."}, {"", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."}, {"hauptstrasse", ""},
                {"              ", "Der Wohnort enthaelt keine Buchstaben."}, {"!strasse", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."},
                /**zu lang **/{"HauptHauptHauptHauptHauptHaupt", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."}, {"Straße", "Der Wohnort enthaelt min. 1 unzulaessiges Zeichen."},
                {"a a", ""}
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public WohnortParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }
            
	    @Test
	    public void test() {
	    	
                wohnort = fInput;
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
	

