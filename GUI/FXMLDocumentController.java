/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.AutoQuery;
import Data.Data;
import Data.Datenbank;
import Data.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author GPope
 */
public class FXMLDocumentController implements Initializable {

    private Data data;

    @FXML
    private Tab kundenliste, vertragsliste;
    @FXML
    private TabPane tabPane;
    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;
    @FXML
    private ListView<String> list3;
    @FXML
    private Button button12;
    @FXML
    private Button carEdit, carb, cari;
    @FXML
    private Button buttonNewCustomer;
    @FXML
    private Button buttonNewContract;
    @FXML
    private Button carDelete;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == button12) {
            new NewCarStage(data);
        } else if (event.getSource() == buttonNewCustomer) {
            new NewCustomerStage(data);
        } else if (event.getSource() == buttonNewContract) {
            new NewContractStage(data);
        } else if (event.getSource() == carDelete) {
            int i = list1.getSelectionModel().getSelectedIndex();
            new AutoQuery().delete(data.getKennzeichen(i, false));
            data.fullUpdate();
        } else if (event.getSource() == carEdit) {
            int i = list1.getSelectionModel().getSelectedIndex();
            new EditCarStage(data.getAuto(i), data);
            data.fullUpdate();
        } else if (event.getSource() == carb) {
            new CarOutputStage(data);
        } else if (event.getSource() == cari) {
            new CarInputStage(data);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = new Data();   
        data.setfxmlDC(this);
        try {
            data.setPassword(new Stream().read());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        updateList();
        
        if (data.getPassword().equals("Gast"))
        {
            button12.setVisible(false);
            carEdit.setVisible(false);
            carDelete.setVisible(false);
            cari.setVisible(false);
            carb.setVisible(false);
            tabPane.getTabs().remove(kundenliste);
            tabPane.getTabs().remove(vertragsliste);
        }
    }

    public void updateList() {
        ObservableList<String> daten = FXCollections.observableArrayList(data.getText(Datenbank.AUTO, false));
        list1.setItems(daten);

        daten = FXCollections.observableArrayList(data.getText(Datenbank.KUNDE, false));
        list2.setItems(daten);

        daten = FXCollections.observableArrayList(data.getText(Datenbank.VERTRAG, false));
        list3.setItems(daten);
    }
}
