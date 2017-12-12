/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author GPope
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private Button button;
    
    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;
    @FXML
    private ListView<String> list3;
    @FXML
    private Button button1;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button121;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> data1 = FXCollections.observableArrayList("Audi A4","VW Polo","Ford Fiesta","Fiat Punto","Honda Accord","VW Golf","Mercedes C-Klasse","Opel Corsa");
        ObservableList<String> data2 = FXCollections.observableArrayList("Max Mustermann","Claire Grube","Hans Hansen","Alfonso von Stein","Anna Alonso","Lena Weber","Günther von Günthingen","Lilly Putt");
        ObservableList<String> data3 = FXCollections.observableArrayList("0648154588","0516135181","0279568436","8974315936","9785642030","0230104250");
        list1.setItems(data1);
        list2.setItems(data2);
        list3.setItems(data3);
    }    
    
}
