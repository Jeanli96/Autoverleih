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
	public class TelefonnummerParamTest{
            
           private int kdID = 2;
           String name = "Topp";
           String vorname = "Markus";
           String plz = "01689";
           String strasse = "Hauptstrasse";
           int hausnummer = 50;
           String wohnort = "Dresden";
           String telefonnummer;
           String geburtsdatum = "12.02.1991";
           String fKlasse = "A2";

		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"0121234324", ""}, {"12", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {"0123451234123451324115", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."},
                {"035876/12345", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {"030-123456", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {"Samsung1", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."},
                {"!!!\\§", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {"h123456", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."},
                {"12345h", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {" 0330   654", ""}, {"+496512312", ""}, {"0+12345", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."},
                {"035877 1234+", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}, {"++4912345", "Die Telefonnummer darf nur aus Zahlen bestehen 3-20 Ziffern."}
            });
            
	    }

	    private String fInput;

	    private String fExpected;

	    public TelefonnummerParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
                telefonnummer = fInput;
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
	

