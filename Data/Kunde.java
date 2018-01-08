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
public class Kunde {

    private int kdID;
    private String name;
    private String vorname;
    private String plz;
    private String strasse;
    private int hausnummer;
    private String wohnort;
    private String telefonnummer;
    private String geburtsdatum;
    private String fKlasse;

    public Kunde(int kdID, String name, String vorname, String plz, String strasse, int hausnummer, String wohnort, String telefonnummer, String geburtsdatum, String fKlasse) throws IllegalArgumentException {
    	
    	if (!name.matches("[a-zA-ZöäüÖÄÜ ]+"))
    		throw new IllegalArgumentException("Der Name enthaelt min. 1 unzulaessiges Zeichen.");
    	
    	if (!vorname.matches("[a-zA-ZöäüÖÄÜ ]+"))
    		throw new IllegalArgumentException("Der Vorname enthaelt min. 1 unzulaessiges Zeichen.");
    	
    	if (!plz.matches("[0-9]+"))
    		throw new IllegalArgumentException("Die PLZ darf nur aus Zahlen bestehen.");
    	
    	if (!strasse.matches("[a-zA-ZöäüÖÄÜ ]+"))
    		throw new IllegalArgumentException("Die Strasse enthaelt min. 1 unzulaessiges Zeichen.");
    	
    	if (!wohnort.matches("[a-zA-ZöäüÖÄÜ ]+"))
    		throw new IllegalArgumentException("Der Wohnort enthaelt min. 1 unzulaessiges Zeichen.");
    	
    	if (!telefonnummer.matches("^\\+?[0-9 ]+"))
    		throw new IllegalArgumentException("Die Telefonnummer darf nur aus Zahlen bestehen.");
    	
    	if (!geburtsdatum.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}"))
    		throw new IllegalArgumentException("Das Geburtsdatum muss im Format DD.MM.YYYY sein.");
    	
    	if (!fKlasse.matches("AM|A1|A2|A|B|BF17|B96|BE|C1|C|CE|D1|D1E|D|DE|T|L"))
    		throw new IllegalArgumentException("Die Telefonnummer darf nur aus Zahlen bestehen.");
    	
        this.kdID = kdID;
        this.name = name;
        this.vorname = vorname;
        this.plz = plz;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.wohnort = wohnort;
        this.telefonnummer = telefonnummer;
        this.geburtsdatum = geburtsdatum;
        this.fKlasse = fKlasse;
    }

    @Override
    public String toString() {
        String text = "KundenID: " + kdID + "\n"
                + "Name: " + name + "\n"
                + "Vorname: " + vorname + "\n"
                + "PLZ: " + plz + "\n"
                + "StraÃŸe: " + strasse + "\n"
                + "Hausnummer: " + hausnummer + "\n"
                + "Wohnort: " + wohnort + "\n"
                + "Telefonnummer: " + telefonnummer + "\n"
                + "Geburtsdatum: " + geburtsdatum + "\n"
                + "FÃ¼hrerscheinklasse: " + fKlasse + "\n";

        return text;
    }
    
    public String anlegen() {
        String text = "'" + kdID + "',"
                + "'" + name + "',"
                + "'" + vorname + "',"
                + "'" + plz + "',"
                + "'" + strasse + "',"
                + "'" + hausnummer + "',"
                + "'" + wohnort + "',"
                + "'" + telefonnummer + "',"
                + "'" + geburtsdatum + "',"
                + "'" + fKlasse + "'";

        return text;
    }

    public int getKdID() {
        return kdID;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public String getWohnort() {
        return wohnort;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getGeburtsdaaum() {
        return geburtsdatum;
    }

    public String getFKlasse() {
        return fKlasse;
    }
}
