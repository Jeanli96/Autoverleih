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
public class AutoQuery {

    final String hostname = "wdb2.hs-mittweida.de";
    final String port = "3306";
    final String dbname = "kmangels";
    String user;
    String password;

    Connection conn = null;

    public Auto[] read() {
        user = "kmangels_ro";
        password = "Va7tho9a";

        Auto[] alleAutos = null;
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
            String sqlCommand = "SELECT count(*) FROM Auto";
            ResultSet rs = stmt.executeQuery(sqlCommand);
            if (rs.next()) {
                alleAutos = new Auto[rs.getInt(1)];

                //System.out.println("* Abfrage beginnen");
                sqlCommand = "SELECT * FROM Auto";
                rs = stmt.executeQuery(sqlCommand);

                for (int i = 0; rs.next(); i++) {
                    alleAutos[i] = new Auto(rs.getString("Kennzeichen"), rs.getString("Marke"), rs.getInt("Sitzplaetze"), rs.getFloat("Tagessatz"),
                            rs.getString("Modell"), rs.getString("Typ"), rs.getString("Farbe"), rs.getString("Maengel"));
                    //System.out.println(alleAutos[i].toString());
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

        return alleAutos;
    }

    public void write(Auto neuesAuto, String uPassword) {

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
            String sqlCommand = "INSERT INTO Auto " + "VALUES(" + neuesAuto.anlegen() + ");";
            stmt.executeUpdate(sqlCommand);

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }
    }

    public void delete(String kennzeichen) {

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
            String sqlCommand = "DELETE FROM Auto WHERE Kennzeichen = '" + kennzeichen + "';";
            stmt.executeUpdate(sqlCommand);

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }
    }
    
    public void edit(Auto auto) {

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
            String sqlCommand = "UPDATE Auto SET Marke = '" + auto.getMarke() + "', Sitzplaetze = '" + auto.getSitzplaetze() + "', Tagessatz = '" + auto.getTagessatz() + "', Modell = '" + auto.getModell() + "', Typ = '" + auto.getTyp() + "', Farbe = '" + auto.getFarbe() + "', Maengel = '" + auto.getMaengel() + "' WHERE Kennzeichen = '" + auto.getKennzeichen() + "';";
            stmt.executeUpdate(sqlCommand);

            //System.out.println("* Statement beenden");
            stmt.close();

            //System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            //sqle.printStackTrace();
        }
    }
}
