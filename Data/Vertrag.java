/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author kevin
 */
public class Vertrag {
    
    private int vertragsID;
    private int kdID;
    private String kennzeichen;
    private String zFahrer;
    private Date abholtermin;
    private Date ruecktermin;
    private Date tatAbholtermin;
    private Date tatRuecktermin;
    

    public Vertrag(int vertragsID, int kdID, String kennzeichen, String zFahrer, Date abholtermin, Date ruecktermin, Date tatAbholtermin, Date tatRuecktermin) 
    {
        this.vertragsID = vertragsID;
        this.kdID = kdID;
        this.kennzeichen = kennzeichen;
        this.zFahrer  = zFahrer;
        this.abholtermin = abholtermin;
        this.ruecktermin = ruecktermin;
        this.tatAbholtermin = tatAbholtermin;
        this.tatRuecktermin = tatRuecktermin;  
    }

    @Override
    public String toString() {
        String text = "Vertrags_ID: " + vertragsID + "\n"
                + "Kunden_ID: " + kdID + "\n"
                + "Kennzeichen: " + kennzeichen + "\n"
                + "Zweitfahrer: " + zFahrer + "\n"
                + "Abholtermin: " + abholtermin + "\n"
                + "Rückgabetermin: " + ruecktermin + "\n"
                + "tat_Abholtermin: " + tatAbholtermin + "\n"
                + "tat_Tückgabetermin: " + tatRuecktermin + "\n";
                

        return text;
    }

    public String anlegen() {
        String text = "'" + vertragsID + "',"
                + "'" + kdID + "',"
                + "'" + kennzeichen + "',"
                + "'" + zFahrer + "',"
                + "'" + abholtermin + "',"
                + "'" + ruecktermin + "',";
        
        if (tatAbholtermin == null)
            text = text + "NULL,";
        else
            text = text + "'" + tatAbholtermin + "',";
        
        if (tatRuecktermin == null)
            text = text + "NULL";
        else
            text = text + "'" + tatRuecktermin + "'";
                 

        return text;
    }
    
    public int getVertragsID() {
        return vertragsID;
    }

    public int getKundenID() {
        return kdID;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getZweitfahrer() {
        return zFahrer;
    }

    public Date getAbholtermin() {
        return abholtermin;
    }

    public Date getRueckgabetermin() {
        return ruecktermin;
    }

    public Date getTatAbholtermin() {
        return tatAbholtermin;
    }

    public Date getTatRueckgabetermin() {
        return tatRuecktermin;
    }
}