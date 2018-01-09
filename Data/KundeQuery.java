/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;

/**
 *
 * @author kevin
 */
public class KundeQuery {

    final String hostname = "wdb2.hs-mittweida.de";
    final String port = "3306";
    final String dbname = "kmangels";
    String user;
    String password;

    Connection conn = null;

    public Kunde[] read(String sqlCommand) {
        user = "kmangels_ro";
        password = "Va7tho9a";

        Kunde[] alleKunden = null;
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

            //System.out.println("* Anzahl der Zeilen bekommen --> alleKunden dimensionieren");
            //String sqlCommand = "SELECT COUNT(*) FROM Kunde";
            ResultSet rs = stmt.executeQuery(sqlCommand);
            if (rs.next()) {
                alleKunden = new Kunde[rs.getInt(1)];

                //System.out.println("* Abfrage beginnen");
                sqlCommand = "SELECT * FROM Kunde";
                rs = stmt.executeQuery(sqlCommand);

                for (int i = 0; rs.next(); i++) {
                    alleKunden[i] = new Kunde(rs.getInt("KDID"), rs.getString("Name"), rs.getString("Vorname"), rs.getString("PLZ"), rs.getString("Strasse"),
                            rs.getInt("Hausnummer"), rs.getString("Wohnort"), rs.getString("Telefonnummer"), rs.getString("Geburtsdatum"), rs.getString("FKlasse"));
                    //System.out.println(alleKunden[i].toString());
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
        }

        return alleKunden;
    }

    public void write(Kunde neuerKunde, String uPassword) {

        user = "kmangels";
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

            //System.out.println("* Einfuegen");
            String sqlCommand = "INSERT INTO Kunde " + "VALUES(" + neuerKunde.anlegen() + ");";
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
