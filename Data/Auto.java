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
    

    public Auto(String kennzeichen, String marke, int sitzplaetze, float tagessatz, String modell, String typ, String farbe, String maengel) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.sitzplaetze = sitzplaetze;
        this.tagessatz = tagessatz;
        this.modell = modell;
        this.typ = typ;
        this.farbe = farbe;
        this.maengel = maengel;
        
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
                + "Mängel: " + maengel;
                

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
