/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
import Data.AutoQuery;
import Data.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class EditCarController implements Initializable {

    private Auto sAuto;
    private Data data;

    @FXML
    private Button bearbeiten;
    @FXML
    private Button abbruch;

    @FXML
    private Label kennzeichen;
    @FXML
    private Label marke;
    @FXML
    private Label modell;
    @FXML
    private Label fahrzeugtyp;
    @FXML
    private Label sitzplaetze;
    @FXML
    private TextField farbe;
    @FXML
    private TextField tagessatz;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //EditCarStage stage = EditCarStage.stage;          
    }
    
    @FXML
    private void buttonBearbeiten() {

        Auto newAuto = new Auto(kennzeichen.getText(), marke.getText(), Integer.parseInt(sitzplaetze.getText()), Float.parseFloat(tagessatz.getText()), modell.getText(), fahrzeugtyp.getText(), farbe.getText(), "keine");
        new AutoQuery().edit(newAuto);

        data.fullUpdate();
        buttonAbbrechen();
    }

    @FXML
    private void buttonAbbrechen() {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close();
    }
    
    public void setStage (Auto selectedAuto)
    {        
        sAuto = selectedAuto;

        kennzeichen.setText(sAuto.getKennzeichen());
        marke.setText(sAuto.getMarke());
        modell.setText(sAuto.getModell());
        fahrzeugtyp.setText(sAuto.getTyp());
        sitzplaetze.setText("" + sAuto.getSitzplaetze());
        farbe.setText(sAuto.getFarbe());
        tagessatz.setText("" + sAuto.getTagessatz());
    }
    
    public void setData(Data data)
    {
        this.data = data;
    }
}
