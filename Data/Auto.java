/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kevin
 */
public class Auto {

    private String kennzeichen;
    private String marke;
    private int sitzplaetze;
    private float tagessatz;
    private String modell;
    private String typ;
    private String farbe;
    private String maengel;
    

    public Auto(String kennzeichen, String marke, int sitzplaetze, float tagessatz, String modell, String typ, String farbe, String maengel) throws IllegalArgumentException {
    	
    	try{
            if ( kennzeichen.length() < 5 )
                throw new IllegalArgumentException("Das angegebene Kennzeichen ist zu kurz.");   
            if ( kennzeichen.length() > 10  )
            	throw new IllegalArgumentException("Das angegebene Kennzeichen ist zu lang.");                        
        //  TESTEN nach Zahlen und Buchstaben vorn und hinten
            
            String pattern = "^[A-Z]{1,3}-[A-Z]{1,2}-[0-9]{1,4}";
            if ( !kennzeichen.matches(pattern))
                throw new IllegalArgumentException("Das angegebene Kennzeichen entfaellt der Norm.");
            
            if (sitzplaetze < 1)
            	throw new IllegalArgumentException("Die Sitzzahl darf nicht unter 1 liegen.");
            if (sitzplaetze > 7)
            	throw new IllegalArgumentException("Die Sitzzahl darf nicht ueber 7 liegen.");
            
            if (tagessatz <= 0)
            	throw new IllegalArgumentException("Der Tagessatz darf nicht unter 0 liegen.");
            	
        
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.sitzplaetze = sitzplaetze;
        this.tagessatz = tagessatz;
        this.modell = modell;
        this.typ = typ;
        this.farbe = farbe;
        this.maengel = maengel;
    	} finally{}
        
    }

    @Override
    public String toString() {
        String text = "Kennzeichen: " + kennzeichen + "\n"
                + "Marke: " + marke + "\n"
                + "Sitzplätze: " + sitzplaetze + "\n"
                + "Tagessatz: " + tagessatz + "\n"
                + "Modell: " + modell + "\n"
                + "Typ: " + typ + "\n"
                + "Farbe: " + farbe + "\n"
                + "Maengel: " + maengel;
                

        return text;
    }

    public String anlegen() {
        String text = "'" + kennzeichen + "',"
                + "'" + marke + "',"
                + "'" + sitzplaetze + "',"
                + "'" + tagessatz + "',"
                + "'" + modell + "',"
                + "'" + typ + "',"
                + "'" + farbe + "',"
                + "'" + maengel + "'";
                 

        return text;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getMarke() {
        return marke;
    }

    public int getSitzplaetze() {
        return sitzplaetze;
    }

    public float getTagessatz() {
        return tagessatz;
    }

    public String getModell() {
        return modell;
    }

    public String getTyp() {
        return typ;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getMaengel() {
        return maengel;
    }

   
}
