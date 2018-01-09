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
	public class NameParamTest{
            
           private int kdID = 2;
           String name;
           String vorname = "Markus";
           String plz = "01689";
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort = "Dresden";
           String telefonnummer = "01747589452";
           String geburtsdatum = "12.02.1991";
           String fKlasse = "A2";

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"Sam", ""}, {"1Sam", "Der Name enthaelt min. 1 unzulaessiges Zeichen."}, {"Sa&se", "Der Name enthaelt min. 1 unzulaessiges Zeichen."},
                {"Samß", "Der Name enthaelt min. 1 unzulaessiges Zeichen."}, {"", "Der Name enthaelt min. 1 unzulaessiges Zeichen."}, {"sam", ""},
                {"              ", "Der Name enthaelt min. 1 unzulaessiges Zeichen."}, {"!sme", "Der Name enthaelt min. 1 unzulaessiges Zeichen."},
                /**zu lang **/{"samuelsamuelsamuelsamuelsamuelll", "Der Name enthaelt min. 1 unzulaessiges Zeichen."}, {"Strase<3 ", "Der Name enthaelt min. 1 unzulaessiges Zeichen."},
                {"a a", ""}
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public NameParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                name = fInput;
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
	

