package Tests;



	import static org.junit.Assert.assertEquals;
	import Data.Auto;
	import java.util.Arrays;
	import java.util.Collection;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.junit.runners.Parameterized;
	import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class KennzeichenParamTest {
	    
		String kennzeichen;
	    String marke = "Audi";
	    int sitzplaetze = 3;
	    float tagessatz = 20;
	    String modell = "A3";
	    String typ = "Limousine";
	    String farbe = "Orange";
	    String maengel = "keine";
		
	    
	    
		@Parameters
	    public static Collection<Object[]> data() {
	        
	    	
	    	
	    	
	    return Arrays.asList(new Object[][] {     
	         {"KF-MM-12345" , "Das angegebene Kennzeichen ist zu lang."  }, {"Im-mm-212", "Das angegebene Kennzeichen entfaellt der Norm."},
	         {"I-M-", "Das angegebene Kennzeichen ist zu kurz." }, {"iM-IF-2323", "Das angegebene Kennzeichen entfaellt der Norm."}, 
	         {"IM-iF-2323", "Das angegebene Kennzeichen entfaellt der Norm."}, {"IM-IF-K323", "Das angegebene Kennzeichen entfaellt der Norm."},
	         {"3M-IF-2323", "Das angegebene Kennzeichen entfaellt der Norm."}, {"", "Das angegebene Kennzeichen ist zu kurz." },
	         {"I-M--123", "Das angegebene Kennzeichen entfaellt der Norm." }, {"I-M\\-123", "Das angegebene Kennzeichen entfaellt der Norm." },
	         {"I_M123", "Das angegebene Kennzeichen entfaellt der Norm." }, {"IMG123", "Das angegebene Kennzeichen entfaellt der Norm." },
	         {"ha-ll-oo1o", "Das angegebene Kennzeichen entfaellt der Norm." }, {"sdfdsfd", "Das angegebene Kennzeichen entfaellt der Norm." },
	         {"IM-MK-111", "" }, {"bd\b$fgdfg", "Das angegebene Kennzeichen entfaellt der Norm."}});
	    }

	    private String fInput;

	    private String fExpected;

	    public KennzeichenParamTest(String input, String expected) {
	        fInput= input;
	        fExpected= expected;
	    }

	    @Test
	    public void test() {
	    	
	    	kennzeichen = fInput;
	    	String out = new String();
	    	try{
	    		Auto test = new Auto(kennzeichen, marke, sitzplaetze, tagessatz, modell, typ, farbe, maengel);
	    	}
	    	catch (Exception e){
	    		out = e.getMessage();
	    	}
	    	
	        assertEquals(fExpected, out );
	        fInput= "";
	        fExpected = "";
	    }
	}
	

