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
	public class PlzParamTest{
            
           private int kdID = 2;
           String name = "Topp";
           String vorname ="Markus" ;
           String plz;
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort = "Dresden";
           String telefonnummer = "01747589452";
           String geburtsdatum = "12.02.1991";
           String fKlasse = "A2";

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"01234", ""}, {"000110", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"0110", "Die PLZ darf nur aus 5 Zahlen bestehen."},
                {"99", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"1", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"", "Die PLZ darf nur aus 5 Zahlen bestehen."},
                {"0001!", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"000A0", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"Hamburg", "Die PLZ darf nur aus 5 Zahlen bestehen."},
                {"1+2-3", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {"000110 oder so", "Die PLZ darf nur aus 5 Zahlen bestehen."}, {" 000110", "Die PLZ darf nur aus 5 Zahlen bestehen."},
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public PlzParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                plz = fInput;
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
	

