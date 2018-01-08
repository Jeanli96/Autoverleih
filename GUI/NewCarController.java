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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class NewCarController implements Initializable {

    private Data data;
    
    @FXML
    private Button anlegen;
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
    }

    @FXML
    private void buttonAnlegen() { 
        
        String holder = "";
        
        switch (fahrzeugtyp.getSelectionModel().getSelectedIndex())
        {
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
        
        try
        {
        	if (data.getAuto(kennzeichen.getText()) != null)
        		throw new IllegalArgumentException("Das angegebene Kennzeichen ist schon vorhanden");
        	
        		String tagessatz = this.tagessatz.getText();
        		System.out.println(tagessatz);
        		tagessatz = tagessatz.replace(",", ".");
        		System.out.println(tagessatz);
        		System.out.println(Float.parseFloat(tagessatz));
        		
        		Auto newAuto = new Auto(kennzeichen.getText(), marke.getText(), Integer.parseInt(sitzplaetze.getText()), Float.parseFloat(tagessatz), modell.getText(), holder, farbe.getText(), "keine");
        		new AutoQuery().write(newAuto, data.getPassword());

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
            
            if (message.contains("For input"))
            	message = "Fehlerhafte Eingabe. Bitte die angegebenen Daten ueberpruefen.";
            
            vbox.getChildren().addAll(new Text(message), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        }
    }

    @FXML
    private void buttonAbbrechen() 
    {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close(); 
    }
    
    public void setData(Data data)
    {
        this.data = data;
    }
}
