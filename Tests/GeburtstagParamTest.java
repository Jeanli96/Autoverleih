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
	public class GeburtstagParamTest {
            
           private int kdID = 2;
           String name = "Topp";
           String vorname = "Markus";
           String plz = "01689";
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort = "Dresden";
           String telefonnummer = "0123456789";
           String geburtsdatum;
           String fKlasse = "A2";

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"12.02.1991",  "" }, {"32.05.1991", "Fehlerhaftes Geburtsdatum DD.MM.YYYY."}, {"12.00.1992", "Fehlerhaftes Geburtsdatum DD.MM.YYYY."},
                {"12.02.2025", "Geburtsdatum liegt in der Zukunft."}, {"01.01.983", "Das Geburtsdatum muss im Format DD.MM.YYYY sein."}, { "01.1.1995", "Das Geburtsdatum muss im Format DD.MM.YYYY sein."},
                {"1.02.1997", "Das Geburtsdatum muss im Format DD.MM.YYYY sein."},{"\"§.10.1998", "Das Geburtsdatum muss im Format DD.MM.YYYY sein."}, {"1991.12.10", "Das Geburtsdatum muss im Format DD.MM.YYYY sein."},
                {"12.13.1953", "Fehlerhaftes Geburtsdatum DD.MM.YYYY."}});
            
	    }

	    private String fInput;

	    private String fExpected;

	    public GeburtstagParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                geburtsdatum = fInput;
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
	

