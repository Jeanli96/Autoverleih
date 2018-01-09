/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import GUI.FXMLDocumentController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author kevin
 */
public class Data {

    private Kunde[] angKunden = null, alleKunden = null;
    private Auto[] angAutos = null, alleAutos = null;
    private Vertrag[] angVertraege = null, alleVertraege = null;
    private FXMLDocumentController fxmlDC = null;
    private String password = "old_Data";

    public Data() {
        angKunden = new KundeQuery().read("SELECT COUNT(*) FROM Kunde");
        angAutos = new AutoQuery().read("SELECT count(*) FROM Auto");
        angVertraege = new VertragQuery().read("SELECT count(*) FROM Vertraege");

        alleKunden = angKunden;
        alleAutos = angAutos;
        alleVertraege = angVertraege;

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }
    }

    //Fehlende Abfrage/Fehlerbehandlung: nach Update wenn Kunden == null, dann Fehlermelden
    public void fullUpdate() {
        angKunden = new KundeQuery().read("SELECT COUNT(*) FROM Kunde");
        angAutos = new AutoQuery().read("SELECT count(*) FROM Auto");
        angVertraege = new VertragQuery().read("SELECT count(*) FROM Vertraege");

        alleKunden = angKunden;
        alleAutos = angAutos;
        alleVertraege = angVertraege;

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }

        fxmlDC.updateList();
    }
    
    public void update(Datenbank type, String sqlCommand)
    {
        switch (type) {
            case AUTO:
                angAutos = new AutoQuery().read(sqlCommand);
                break;
            case KUNDE:
                angKunden = new KundeQuery().read(sqlCommand);
                break;
            case VERTRAG:
                angVertraege = new VertragQuery().read(sqlCommand);
                break;
        }

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }

    }
    
    public void hasCarTime(String kennzeichen, Date pDate, Date rDate) throws IllegalArgumentException
    {
    	boolean hold = true;
    	
    	for (int i = 0; i < alleVertraege.length; i++)
    	{
    		if (alleVertraege[i].getKennzeichen().equals(kennzeichen))
    		{
    			if (pDate.before(alleVertraege[i].getRueckgabetermin()) && pDate.after(alleVertraege[i].getAbholtermin()))
    				hold = false;
    			if (rDate.before(alleVertraege[i].getRueckgabetermin()) && rDate.after(alleVertraege[i].getAbholtermin()))
    				hold = false;
    			
    			if (!hold)
    			{	
    				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    				Calendar c = df.getCalendar();
    				
    				c.setTime(alleVertraege[i].getAbholtermin());
                	String d1 = c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);
                	
                	c.setTime(alleVertraege[i].getRueckgabetermin());
                	String d2 = c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);
                	
    				throw new IllegalArgumentException("Das Auto steht vom " + d1 + " bis zum " + d2 + " nicht zur Verfuegung.");
    			}
    		}
    	}
    }

    public void setfxmlDC(FXMLDocumentController fxmlDC) {
        this.fxmlDC = fxmlDC;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }

    public int getNextKDID() {
        return alleKunden.length + 1;
    }

    public int getNextVID() {
        return alleVertraege.length + 1;
    }

    public String getKennzeichen(int i, boolean all) {
        if (all == false)
            return angAutos[i].getKennzeichen();
        else
            return alleAutos[i].getKennzeichen();
    }
    
    public int getKundenID(int i, boolean all) {
        if (all == false)
            return angKunden[i].getKdID();
        else
            return alleKunden[i].getKdID();
    }
    
    public int getVertragID(int i, boolean all) {
        if (all == false)
            return angVertraege[i].getVertragsID();
        else
            return alleVertraege[i].getVertragsID();
    }
    
    public Vertrag getVertrag(int i, boolean all)
    {
        if (!all)
            return angVertraege[i];
        else
            return alleVertraege[i];
    }

    public Auto getAuto(int i, boolean all) {
        if (!all)
            return angAutos[i];
        else
            return alleAutos[i];
    }
    
    public Auto getAuto(String knz)
    {
        Auto holder = null;
        for (int i = 0; i < alleAutos.length; i++)
        {
            if (alleAutos[i].getKennzeichen().equals(knz))
            {
                holder = alleAutos[i];
                break;
            }
        }
        return holder;
    }
    
    public Kunde getKunde(int i, boolean all)
    {
        if (!all)
            return angKunden[i];
        else
            return alleKunden[i];
    }

    public String[] getText(Datenbank type, boolean all) {
        String[] holder = null;
        
        if (all == false) {
            switch (type) {
                case AUTO:
                    holder = new String[angAutos.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = angAutos[i].getMarke() + " | " + angAutos[i].getModell();
                    }
                    break;
                case KUNDE:
                    holder = new String[angKunden.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = "Nr.: " + angKunden[i].getKdID() + " | " + angKunden[i].getName() + ", " + angKunden[i].getVorname();
                    }
                    break;
                case MITARBEITER:
                    break;
                case VERTRAG:
                    holder = new String[angVertraege.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = "Nr.: " + angVertraege[i].getVertragsID() + " | " + angVertraege[i].getKennzeichen() + " | " + new VertragQuery().getKundenName(angVertraege[i].getKundenID(), password);
                    }
                    break;
            }
        } else {
            switch (type) {
                case AUTO:
                    holder = new String[alleAutos.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = alleAutos[i].getKennzeichen() + " | " +alleAutos[i].getMarke() + " | " + alleAutos[i].getModell();
                    }
                    break;
                case KUNDE:
                    holder = new String[alleKunden.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = "Nr.: " + alleKunden[i].getKdID() + " | " + alleKunden[i].getName() + ", " + alleKunden[i].getVorname();
                    }
                    break;
                case MITARBEITER:
                    break;
                case VERTRAG:
                    holder = new String[alleVertraege.length];
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = "Nr.: " + alleVertraege[i].getVertragsID() + " | " + alleVertraege[i].getKennzeichen() + " | " + new VertragQuery().getKundenName(alleVertraege[i].getKundenID(), password);
                    }
                    break;
            }
        }
        return holder;
    }
    
    public Vertrag[] getCarOutput()
    {
        int count = 0;
        Vertrag[] vertrag;
        
        for (int i = 0; i < alleVertraege.length; i++)
        {
            if (alleVertraege[i].getTatAbholtermin() == null)
                count++;
        }
        
        if (count > 0)
            vertrag = new Vertrag[count];
        else
            vertrag = null;
        
        count = 0;
        
        for (int i = 0; i < alleVertraege.length; i++)
        {
            if (alleVertraege[i].getTatAbholtermin() == null)
            {
                vertrag[count] = alleVertraege[i];
                count++;
            }
        }
        return vertrag;
    }
    
    public Vertrag[] getCarInput()
    {
        int count = 0;
        Vertrag[] vertrag;
        
        for (int i = 0; i < alleVertraege.length; i++)
        {
            if (alleVertraege[i].getTatRueckgabetermin() == null && alleVertraege[i].getTatAbholtermin() != null)
                count++;
        }
        
        if (count > 0)
            vertrag = new Vertrag[count];
        else
            vertrag = null;
        
        count = 0;
        
        for (int i = 0; i < alleVertraege.length; i++)
        {
            if (alleVertraege[i].getTatRueckgabetermin() == null && alleVertraege[i].getTatAbholtermin() != null)
            {
                vertrag[count] = alleVertraege[i];
                count++;
            }
        }
        return vertrag;
    }
}
