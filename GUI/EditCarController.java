/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
import Data.AutoQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class EditCarController implements Initializable {

    private Auto sAuto;

    @FXML
    private Button bearbeiten;
    @FXML
    private Button abbruch;

    @FXML
    private TextField kennzeichen;
    @FXML
    private TextField marke;
    @FXML
    private TextField modell;
    @FXML
    private ChoiceBox fahrzeugtyp;
    @FXML
    private TextField sitzplaetze;
    @FXML
    private TextField farbe;
    @FXML
    private TextField tagessatz;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> daten = FXCollections.observableArrayList("Kleinwagen", "Van", "Kombi", "Transporter", "Limousine");
        fahrzeugtyp.setItems(daten);

        EditCarStage stage = EditCarStage.stage;
        sAuto = stage.getAuto();

        kennzeichen.setText(sAuto.getKennzeichen());
        marke.setText(sAuto.getMarke());
        modell.setText(sAuto.getModell());
        sitzplaetze.setText("" + sAuto.getSitzplaetze());
        farbe.setText(sAuto.getFarbe());
        tagessatz.setText("" + sAuto.getTagessatz());

        switch (sAuto.getModell()) {
            case "Kleinwagen":
                fahrzeugtyp.getSelectionModel().select(0);
                break;
            case "Van":
                fahrzeugtyp.getSelectionModel().select(1);
                break;
            case "Kombi":
                fahrzeugtyp.getSelectionModel().select(2);
                break;
            case "Transporter":
                fahrzeugtyp.getSelectionModel().select(3);
                break;
            case "Limousine":
                fahrzeugtyp.getSelectionModel().select(4);
                break;
        }
    }
    
    @FXML
    private void buttonBearbeiten() {

        String holder = "";

        switch (fahrzeugtyp.getSelectionModel().getSelectedIndex()) {
            case 0:
                holder = "Kleinwagen";
                break;
            case 1:
                holder = "Van";
                break;
            case 2:
                holder = "Kombi";
                break;
            case 3:
                holder = "Transporter";
                break;
            case 4:
                holder = "Limousine";
                break;
        }

        Auto newAuto = new Auto(kennzeichen.getText(), marke.getText(), Integer.parseInt(sitzplaetze.getText()), Float.parseFloat(tagessatz.getText()), modell.getText(), holder, farbe.getText(), "keine");
        new AutoQuery().edit(newAuto);

        FXMLMain.data.fullUpdate();
        buttonAbbrechen();
    }

    @FXML
    private void buttonAbbrechen() {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close();
    }
}
