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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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
    private TextField kennzeichen;
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

        try {
            String tagessatz = this.tagessatz.getText();
            tagessatz = tagessatz.replace(",", ".");

            Auto newAuto = new Auto(sAuto.getAutoID(), kennzeichen.getText(), marke.getText(), Integer.parseInt(sitzplaetze.getText()), Float.parseFloat(tagessatz), modell.getText(), fahrzeugtyp.getText(), farbe.getText(), "keine");
            new AutoQuery().edit(newAuto);

            final Stage info = new Stage();
            info.initModality(Modality.WINDOW_MODAL);
            Button ok = new Button("OK");
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    info.close();
                }
            });
            VBox vbox = new VBox(2);
            vbox.getChildren().addAll(new Label("Das Auto mit dem Kennzeichen " + kennzeichen.getText() + " wurde bearbeitet."), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));
            info.setScene(new Scene(vbox));
            info.show();

            data.fullUpdate();
            buttonAbbrechen();
        } catch (IllegalArgumentException e) {
            final Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Button ok = new Button("OK");
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    dialogStage.close();
                }
            });

            VBox vbox = new VBox(2);

            String message = e.getMessage();

            if (message.contains("For input")) {
                message = "Fehlerhafte Eingabe. Bitte die angegebenen Daten ueberpruefen.";
            }

            vbox.getChildren().addAll(new Text(message), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        }
    }

    @FXML
    private void buttonAbbrechen() {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close();
    }

    public void setStage(Auto selectedAuto) {
        sAuto = selectedAuto;

        kennzeichen.setText(sAuto.getKennzeichen());
        marke.setText(sAuto.getMarke());
        modell.setText(sAuto.getModell());
        fahrzeugtyp.setText(sAuto.getTyp());
        sitzplaetze.setText("" + sAuto.getSitzplaetze());
        farbe.setText(sAuto.getFarbe());
        tagessatz.setText("" + sAuto.getTagessatz());
    }

    public void setData(Data data) {
        this.data = data;
    }
}
