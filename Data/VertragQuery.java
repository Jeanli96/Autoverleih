/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class VertragQuery {

    final String hostname = "wdb2.hs-mittweida.de";
    final String port = "3306";
    final String dbname = "kmangels";
    String user;
    String password;

    Connection conn = null;

    public Vertrag[] read() {
        user = "kmangels_ro";
        password = "Va7tho9a";

        Vertrag[] alleVertraege = null;
        try {
            //System.out.println("* Treiber laden");
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Treiber konnte nicht geladen werden.");
            //e.printStackTrace();
        }
        try {
            //System.out.println("* Verbindung aufbauen");
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, user, password);

            //System.out.println("* Statement beginnen");
            Statement stmt = conn.createStatement();

            //System.out.println("* Anzahl der Zeilen bekommen --> alleAutos dimensionieren");
            String sqlCommand = "SELECT count(*) FROM Vertraege";
            ResultSet rs = stmt.executeQuery(sqlCommand);
            if (rs.next()) {
                alleVertraege = new Vertrag[rs.getInt(1)];

                //System.out.println("* Abfrage beginnen");
                sqlCommand = "SELECT * FROM Vertraege";
                rs = stmt.executeQuery(sqlCommand);

                for (int i = 0; rs.next(); i++) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                    Date pDate = null, rDate = null, tpDate = null, trDate = null;
                    
                    pDate = formatter.parse(rs.getString("Abholtermin"));
                    rDate = formatter.parse(rs.getString("Rueckgabetermin"));
                    if (rs.getString("tat_Abholtermin") != null)
                        tpDate = formatter.parse(rs.getString("tat_Abholtermin"));
                    if (rs.getString("tat_Rueckgabetermin") != null)
                        trDate = formatter.parse(rs.getString("tat_Rueckgabetermin"));

                    alleVertraege[i] = new Vertrag(rs.getInt("Vertrags_ID"), rs.getInt("KD_ID"), rs.getString("Kennzeichen"), rs.getString("Zweitfahrer"),
                            pDate, rDate, tpDate, trDate);
                    //System.out.println(alleVertraege[i].toString());
                }
            }

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            //System.out.println("SQLException: " + sqle.getMessage());
            //System.out.println("SQLState: " + sqle.getSQLState());
            //System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        } catch (ParseException ex) {
            //Logger.getLogger(VertragQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alleVertraege;
    }

    public String getKundenName(int KDID, String uPassword) {

        String holder = "";
        
        user = "kmangels_ro";
        password = uPassword;

        try {
            //System.out.println("* Treiber laden");
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Treiber konnte nicht geladen werden.");
            //e.printStackTrace();
        }
        try {
            //System.out.println("* Verbindung aufbauen");
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, user, password);

            //System.out.println("* Statement beginnen");
            Statement stmt = conn.createStatement();

            //System.out.println("* Anzahl der Zeilen bekommen --> alleAutos dimensionieren");
            String sqlCommand = "SELECT Name,Vorname FROM Kunde WHERE KDID = " + KDID;
            ResultSet rs = stmt.executeQuery(sqlCommand);
            if (rs.next()) {
                holder = rs.getString("Name") + ", " + rs.getString("Vorname");
            }

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            //System.out.println("SQLException: " + sqle.getMessage());
            //System.out.println("SQLState: " + sqle.getSQLState());
            //System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }

        return holder;
    }

    public void write(Vertrag neuerVertrag) {

        user = "kmangels";
        password = "Eid3aih3";

        try {
            //System.out.println("* Treiber laden");
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Treiber konnte nicht geladen werden.");
            //e.printStackTrace();
        }
        try {
            //System.out.println("* Verbindung aufbauen");
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, user, password);

            //System.out.println("* Statement beginnen");
            Statement stmt = conn.createStatement();

            //System.out.println("* Einfuegen");
            String sqlCommand = "INSERT INTO Vertraege " + "VALUES(" + neuerVertrag.anlegen() + ");";
            stmt.executeUpdate(sqlCommand);

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            //System.out.println("SQLException: " + sqle.getMessage());
            //System.out.println("SQLState: " + sqle.getSQLState());
            //System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }
    }
    
    public void editTatAbholtermin(int ID, String abholtermin) {

        user = "kmangels";
        password = "Eid3aih3";

        try {
            //System.out.println("* Treiber laden");
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Treiber konnte nicht geladen werden.");
            //e.printStackTrace();
        }
        try {
            //System.out.println("* Verbindung aufbauen");
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
            conn = DriverManager.getConnection(url, user, password);

            //System.out.println("* Statement beginnen");
            Statement stmt = conn.createStatement();

            //System.out.println("* Einfuegen");
            String sqlCommand = "UPDATE Vertraege SET tat_Abholtermin = '" + abholtermin + "' WHERE Vertrags_ID = '" + ID + "';";
            stmt.executeUpdate(sqlCommand);

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            //System.out.println("SQLException: " + sqle.getMessage());
            //System.out.println("SQLState: " + sqle.getSQLState());
            //System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }
    }
}
