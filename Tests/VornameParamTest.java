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
	public class VornameParamTest{
            
           private int kdID = 2;
           String name = "Topp";
           String vorname ;
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
	         {"Sam", ""}, {"1Sam", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."}, {"Sa&se", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."},
                {"Samß", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."}, {"", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."}, {"sam", ""},
                {"              ", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."}, {"!sme", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."},
                /**zu lang **/{"samuelsamuelsamuelsamuelsamuelll", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."}, {"Strase<3 ", "Der Vorname enthaelt min. 1 unzulaessiges Zeichen."},
                {"a a", ""}
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public VornameParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                vorname = fInput;
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
	

