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
    private int autoID;
    private String zFahrer;
    private Date abholtermin;
    private Date ruecktermin;
    private Date tatAbholtermin;
    private Date tatRuecktermin;
    
    public Vertrag()
    {
        this.vertragsID = -1;
        this.kdID = 0;
        this.autoID = 0;
        this.zFahrer  = null;
        this.abholtermin = null;
        this.ruecktermin = null;
        this.tatAbholtermin = null;
        this.tatRuecktermin = null; 
    }
    

    public Vertrag(int vertragsID, int kdID, int autoID, String zFahrer, Date abholtermin, Date ruecktermin, Date tatAbholtermin, Date tatRuecktermin) 
    {
        this.vertragsID = vertragsID;
        this.kdID = kdID;
        this.autoID = autoID;
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
                + "Kennzeichen: " + autoID + "\n"
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
                + "'" + autoID + "',"
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

    public int getAutoID() {
        return autoID;
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
