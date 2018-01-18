/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import GUI.FXMLDocumentController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String sqlCommandKunde = "", sqlCommandAuto = "", sqlCommandVertrag = "";

    public Data() {
        angKunden = new KundeQuery().read("");
        angAutos = getAngAutos("");
        angVertraege = new VertragQuery().read("");

        alleKunden = angKunden;
        alleAutos = new AutoQuery().read("");
        alleVertraege = angVertraege;

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }
    }

    //Fehlende Abfrage/Fehlerbehandlung: nach Update wenn Kunden == null, dann Fehlermelden
    public void fullUpdate() {
        angKunden = new KundeQuery().read(sqlCommandKunde);
        angAutos = getAngAutos(sqlCommandAuto);
        angVertraege = new VertragQuery().read(sqlCommandVertrag);

        alleKunden = new KundeQuery().read("");
        alleAutos = new AutoQuery().read("");
        alleVertraege = new VertragQuery().read("");

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }

        fxmlDC.updateList();
    }

    public void update(Datenbank type, String sqlCommand) {
        switch (type) {
            case AUTO:
                angAutos = getAngAutos(sqlCommand);
                sqlCommandAuto = sqlCommand;
                break;
            case KUNDE:
                angKunden = new KundeQuery().read(sqlCommand);
                sqlCommandKunde = sqlCommand;
                break;
            case VERTRAG:
                angVertraege = new VertragQuery().read(sqlCommand);
                sqlCommandVertrag = sqlCommand;
                break;
        }

        if (angKunden == null || angAutos == null || angVertraege == null) {
            System.out.println("! Error !\n!!!!!!!!!!!!!\nDaten konnten nicht vollständig aus der Datenbank gelesen werden.");
        }

        fxmlDC.updateList();
    }

    private Auto[] getAngAutos(String sqlCommand) {
        Auto[] rawAutos = new AutoQuery().read(sqlCommand);
        Auto[] finishedAutos;
        int counter = 0;

        for (int i = 0; i < rawAutos.length; i++) {
            if (!rawAutos[i].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                counter++;
            }
        }

        finishedAutos = new Auto[counter];
        counter = 0;

        for (int i = 0; i < rawAutos.length; i++) {
            if (!rawAutos[i].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                finishedAutos[counter] = rawAutos[i];
                counter++;
            }
        }

        return finishedAutos;
    }

    public void hasCarTime(String kennzeichen, Date pDate, Date rDate) throws IllegalArgumentException {
        boolean hold = true;

        for (int i = 0; i < alleVertraege.length; i++) {
            if (alleAutos[alleVertraege[i].getAutoID() - 1].getKennzeichen().equals(kennzeichen)) {
                if (pDate.before(alleVertraege[i].getRueckgabetermin()) && pDate.after(alleVertraege[i].getAbholtermin())) {
                    hold = false;
                }
                if (rDate.before(alleVertraege[i].getRueckgabetermin()) && rDate.after(alleVertraege[i].getAbholtermin())) {
                    hold = false;
                }

                if (!hold) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getNextKDID() {
        return alleKunden.length + 1;
    }

    public int getNextVID() {
        return alleVertraege.length + 1;
    }

    public int getNextAutoID() {
        return alleAutos.length + 1;
    }

    public String getKennzeichen(int i, boolean all) {
        if (all == false) {
            return angAutos[i].getKennzeichen();
        } else {
            String[] holder = new String[alleAutos.length];
            String[] helper;
            int count = 0;
            for (int a = 0; a < holder.length; a++) {
                holder[a] = alleAutos[a].getKennzeichen();
                if (alleAutos[a].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                    count++;
                }
            }
            helper = new String[holder.length - count];
            count = 0;

            for (int a = 0; a < holder.length; a++) {
                if (!alleAutos[a].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                    helper[count] = holder[a];
                    count++;
                }
            }
            holder = helper;
            return holder[i];
        }
    }

    public int getKundenID(int i, boolean all) {
        if (all == false) {
            return angKunden[i].getKdID();
        } else {
            return alleKunden[i].getKdID();
        }
    }

    public int getVertragID(int i, boolean all) {
        if (all == false) {
            return angVertraege[i].getVertragsID();
        } else {
            return alleVertraege[i].getVertragsID();
        }
    }

    public Vertrag getVertrag(int i, boolean all) {
        if (!all) {
            return angVertraege[i];
        } else {
            return alleVertraege[i];
        }
    }

    public Auto getAuto(int i, boolean all) {
        if (!all) {
            return angAutos[i];
        } else {
            return alleAutos[i];
        }
    }

    public Auto getAuto(String knz) {
        Auto holder = null;
        for (int i = 0; i < alleAutos.length; i++) {
            if (alleAutos[i].getKennzeichen().equals(knz)) {
                holder = alleAutos[i];
                break;
            }
        }
        return holder;
    }

    public Kunde getKunde(int i, boolean all) {
        if (!all) {
            return angKunden[i];
        } else {
            return alleKunden[i];
        }
    }

    public String[] getText(Datenbank type, boolean all) {
        String[] holder = null;

        if (all == false) {
            switch (type) {
                case AUTO:
                    holder = new String[angAutos.length];
                    DecimalFormat df = new DecimalFormat("0.00");
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = angAutos[i].getMarke() + " | " + angAutos[i].getModell() + " | Tagessatz: " + df.format(angAutos[i].getTagessatz()) + "€.";
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
                        holder[i] = "Nr.: " + angVertraege[i].getVertragsID() + " | " + alleAutos[angVertraege[i].getAutoID() - 1].getKennzeichen() + " | " + new VertragQuery().getKundenName(angVertraege[i].getKundenID()) + " " + getStatus(angVertraege[i]);
                    }
                    break;
            }
        } else {
            switch (type) {
                case AUTO:
                    holder = new String[alleAutos.length];
                    String[] helper;
                    int count = 0;
                    for (int i = 0; i < holder.length; i++) {
                        holder[i] = alleAutos[i].getKennzeichen() + " | " + alleAutos[i].getMarke() + " | " + alleAutos[i].getModell();
                        if (alleAutos[i].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                            count++;
                        }
                    }
                    helper = new String[holder.length - count];
                    count = 0;

                    for (int i = 0; i < holder.length; i++) {
                        if (!alleAutos[i].getKennzeichen().equals("Auto nicht mehr im Besitz")) {
                            helper[count] = holder[i];
                            count++;
                        }
                    }
                    holder = helper;

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
                        holder[i] = "Nr.: " + alleVertraege[i].getVertragsID() + " | " + alleAutos[alleVertraege[i].getAutoID() - 1].getKennzeichen() + " | " + new VertragQuery().getKundenName(alleVertraege[i].getKundenID()) + " " + getStatus(alleVertraege[i]);
                    }
                    break;
            }
        }
        return holder;
    }

    private String getStatus(Vertrag vertrag) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());

        String currentDateString = c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);
        java.util.Date currentDate = null;
        try {
            currentDate = df.parse(currentDateString);
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (vertrag.getTatRueckgabetermin() != null) {
            return "(Abgeschlossen)";
        } else if (vertrag.getTatAbholtermin() != null) {
            if (vertrag.getRueckgabetermin().after(currentDate)) {
                return "(Auto ausgeliehen)";
            } else {
                return "(Rückgabe: )" + vertrag.getRueckgabetermin();
            }
        } else if (vertrag.getAbholtermin().after(currentDate)) {
            return "(Offen)";
        } else {
            return "(Abholung: ) " + vertrag.getAbholtermin();
        }
    }

    public Vertrag[] getCarOutput() {
        int count = 0;
        Vertrag[] vertrag;

        for (int i = 0; i < alleVertraege.length; i++) {
            if (alleVertraege[i].getTatAbholtermin() == null) {
                count++;
            }
        }

        if (count > 0) {
            vertrag = new Vertrag[count];
        } else {
            vertrag = null;
        }

        count = 0;

        for (int i = 0; i < alleVertraege.length; i++) {
            if (alleVertraege[i].getTatAbholtermin() == null) {
                vertrag[count] = alleVertraege[i];
                count++;
            }
        }
        return vertrag;
    }

    public Vertrag[] getCarInput() {
        int count = 0;
        Vertrag[] vertrag;

        for (int i = 0; i < alleVertraege.length; i++) {
            if (alleVertraege[i].getTatRueckgabetermin() == null && alleVertraege[i].getTatAbholtermin() != null) {
                count++;
            }
        }

        if (count > 0) {
            vertrag = new Vertrag[count];
        } else {
            vertrag = null;
        }

        count = 0;

        for (int i = 0; i < alleVertraege.length; i++) {
            if (alleVertraege[i].getTatRueckgabetermin() == null && alleVertraege[i].getTatAbholtermin() != null) {
                vertrag[count] = alleVertraege[i];
                count++;
            }
        }
        return vertrag;
    }

    public Auto[] getAlleAutos() {
        return alleAutos;
    }

    public int getAutoID(String kennzeichen) {
        int i = 0;

        while (!kennzeichen.equals(alleAutos[i].getKennzeichen()) && i < alleAutos.length) {
            i++;
        }

        return (i + 1);
    }
}
