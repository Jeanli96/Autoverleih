/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Data;
import Data.Kunde;
import Data.KundeQuery;
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
 * FXML Controller class
 *
 * @author kevin
 */
public class NewCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Data data;

    @FXML
    private Button anlegen;
    @FXML
    private Button abbruch;

    @FXML
    private TextField name;
    @FXML
    private TextField vorname;
    @FXML
    private TextField plz;
    @FXML
    private TextField wohnort;
    @FXML
    private TextField strasse;
    @FXML
    private TextField hausnummer;
    @FXML
    private TextField telefonnummer;
    @FXML
    private TextField geburtsdatum;
    @FXML
    private TextField fklasse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonAnlegen() {
        try {
            Kunde newKunde = new Kunde(data.getNextKDID(), name.getText(), vorname.getText(), plz.getText(), strasse.getText(), Integer.parseInt(hausnummer.getText()), wohnort.getText(), telefonnummer.getText(), geburtsdatum.getText(), fklasse.getText());
            new KundeQuery().write(newKunde, data.getPassword());

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
            vbox.getChildren().addAll(new Label("Neuer Kunde wurde angelegt."), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));
            info.setScene(new Scene(vbox));
            info.show();
            
            data.fullUpdate();
            buttonAbbruch();
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
    private void buttonAbbruch() {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close();
    }

    public void setData(Data data) {
        this.data = data;
    }
}
