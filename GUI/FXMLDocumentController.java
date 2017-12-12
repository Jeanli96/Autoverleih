/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.AutoQuery;
import Data.Data;
import Data.Datenbank;
import java.io.IOException;
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

    private Data data;

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
            new NewCarStage();
        } else if (event.getSource() == buttonNewCustomer) {
            new NewCustomerStage();
        } else if (event.getSource() == buttonNewContract) {
            new NewContractStage();
        } else if (event.getSource() == carDelete) {
            int i = list1.getSelectionModel().getSelectedIndex();
            new AutoQuery().delete(data.getKennzeichen(i, false));
            data.fullUpdate();
        } else if (event.getSource() == carEdit) {
            int i = list1.getSelectionModel().getSelectedIndex();
            new EditCarStage(data.getAuto(i));
            data.fullUpdate();
        } else if (event.getSource() == carb) {
            new CarOutputStage();
        } else if (event.getSource() == cari) {
            new CarInputStage();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXMLMain.data;
        data.setfxmlDC(this);
        updateList();
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
