/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import GUI.FXMLDocumentController;
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

    public Data() {
        angKunden = new KundeQuery().read();
        angAutos = new AutoQuery().read();
        angVertraege = new VertragQuery().read();

        alleKunden = angKunden;
        alleAutos = angAutos;
        alleVertraege = angVertraege;

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }
    }

    //Fehlende Abfrage/Fehlerbehandlung: nach Update wenn Kunden == null, dann Fehlermelden
    public void fullUpdate() {
        angKunden = new KundeQuery().read();
        angAutos = new AutoQuery().read();
        angVertraege = new VertragQuery().read();

        alleKunden = angKunden;
        alleAutos = angAutos;
        alleVertraege = angVertraege;

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }

        fxmlDC.updateList();
    }

    public void setfxmlDC(FXMLDocumentController fxmlDC) {
        this.fxmlDC = fxmlDC;
    }

    public int getNextKDID() {
        return new KundeQuery().read().length + 1;
    }

    public int getNextVID() {
        return new VertragQuery().read().length + 1;
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
        if (all == false)
            return angVertraege[i];
        else
            return alleVertraege[i];
    }

    public Auto getAuto(int i) {
        return angAutos[i];
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
                        holder[i] = "Nr.: " + angVertraege[i].getVertragsID() + " | " + angVertraege[i].getKennzeichen() + " | " + new VertragQuery().getKundenName(angVertraege[i].getKundenID());
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
                        holder[i] = "Nr.: " + alleVertraege[i].getVertragsID() + " | " + alleVertraege[i].getKennzeichen() + " | " + new VertragQuery().getKundenName(alleVertraege[i].getKundenID());
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
