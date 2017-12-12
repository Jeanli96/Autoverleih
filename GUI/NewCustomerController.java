/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Kunde;
import Data.KundeQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private void buttonAnlegen()
    {
        Kunde newKunde = new Kunde(FXMLMain.data.getNextKDID() ,name.getText(), vorname.getText(), plz.getText(), strasse.getText(), Integer.parseInt(hausnummer.getText()), wohnort.getText(), telefonnummer.getText(), geburtsdatum.getText(), fklasse.getText());
        new KundeQuery().write(newKunde);
        
        FXMLMain.data.fullUpdate();
        buttonAbbruch();
    }
    
    @FXML
    private void buttonAbbruch()
    {
        Stage stage = (Stage) abbruch.getScene().getWindow();
        stage.close();   
    }
}
