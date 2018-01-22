/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
import Data.AutoQuery;
import Data.Data;
import Data.Datenbank;
import static Data.Datenbank.AUTO;
import Data.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private Button buttonNewCustomer, buttonEditCustomer;
    @FXML
    private Button buttonNewContract, buttonEditContract;
    @FXML
    private Button carDelete;
    @FXML
    private CheckBox audi, fiat, ford, honda, mercedes, opel, vw;
    @FXML
    private CheckBox seating1, seating2, seating3, seating4, seating5, seating6, seating7;
    @FXML
    private CheckBox ascending, descending;
    @FXML
    private CheckBox kleinwagen, van, kombi, transporter, limousine;

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
            Auto holder = data.getAuto(i, false);
            
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
            vbox.getChildren().addAll(new Label("Das Auto mit dem Kennzeichen " + holder.getKennzeichen() + " wurde aus dem System entfernt."), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));
            info.setScene(new Scene(vbox));
            info.show();
            
            holder.deleteKennzeichen();
            new AutoQuery().edit(holder);
            data.fullUpdate();
        } else if (event.getSource() == carEdit) {
            int i = list1.getSelectionModel().getSelectedIndex();
            new EditCarStage(data.getAuto(i, false), data);
            data.fullUpdate();
        } else if (event.getSource() == carb) {
            new CarOutputStage(data);
        } else if (event.getSource() == cari) {
            new CarInputStage(data);
        } else if (event.getSource() == buttonEditContract) {
            int i = list3.getSelectionModel().getSelectedIndex();
            new EditContractStage(data, data.getVertrag(i, false));
        } else if (event.getSource() == buttonEditCustomer)
        {
            int i = list2.getSelectionModel().getSelectedIndex();
            new EditCustomerStage(data, data.getKunde(i, false));
        }
    }

    @FXML
    public void sort(ActionEvent event) {

        if (event.getSource() == ascending) {
            descending.setSelected(false);
        } else if (event.getSource() == descending) {
            ascending.setSelected(false);
        }

        String sqlCommand = "";
        String marke = "";
        String sitze = "";
        String tagessatz = "";
        String typ = "";
        String verfuegbar = "";
        String subCommand = "";
        boolean wasSelected = false;

        if (audi.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Audi\"";
            } else {
                marke += " OR Marke = \"Audi\"";
            }
            wasSelected = true;
        }
        if (fiat.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Fiat\"";
            } else {
                marke += " OR Marke = \"Fiat\"";
            }
            wasSelected = true;
        }
        if (ford.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Ford\"";
            } else {
                marke += " OR Marke = \"Ford\"";
            }
            wasSelected = true;
        }
        if (honda.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Honda\"";
            } else {
                marke += " OR Marke = \"Honda\"";
            }
            wasSelected = true;
        }
        if (mercedes.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Mercedes\"";
            } else {
                marke += " OR Marke = \"Mercedes\"";
            }
            wasSelected = true;
        }
        if (opel.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"Opel\"";
            } else {
                marke += " OR Marke = \"Opel\"";
            }
            wasSelected = true;
        }
        if (vw.isSelected()) {
            if (!wasSelected) {
                marke += " Marke = \"VW\"";
            } else {
                marke += " OR Marke = \"VW\"";
            }
            wasSelected = true;
        }

        wasSelected = false;

        if (seating1.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 1";
            } else {
                sitze += " OR Sitzplaetze = 1";
            }
            wasSelected = true;
        }
        if (seating2.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 2";
            } else {
                sitze += " OR Sitzplaetze = 2";
            }
            wasSelected = true;
        }
        if (seating3.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 3";
            } else {
                sitze += " OR Sitzplaetze = 3";
            }
            wasSelected = true;
        }
        if (seating4.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 4";
            } else {
                sitze += " OR Sitzplaetze = 4";
            }
            wasSelected = true;
        }
        if (seating5.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 5";
            } else {
                sitze += " OR Sitzplaetze = 5";
            }
            wasSelected = true;
        }
        if (seating6.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 6";
            } else {
                sitze += " OR Sitzplaetze = 6";
            }
            wasSelected = true;
        }
        if (seating7.isSelected()) {
            if (!wasSelected) {
                sitze += " Sitzplaetze = 7";
            } else {
                sitze += " OR Sitzplaetze = 7";
            }
            wasSelected = true;
        }

        if (ascending.isSelected()) {
            tagessatz += " ORDER BY Tagessatz ASC";
        } else if (descending.isSelected()) {
            tagessatz += " ORDER BY Tagessatz DESC";
        }

        wasSelected = false;

        if (kleinwagen.isSelected()) {
            if (!wasSelected) {
                typ += " Typ = \"Kleinwagen\"";
            } else {
                typ += " OR Typ = \"Kleinwagen\"";
            }
            wasSelected = true;
        }
        if (van.isSelected()) {
            if (!wasSelected) {
                typ += " Typ = \"Van\"";
            } else {
                typ += " OR Typ = \"Van\"";
            }
            wasSelected = true;
        }
        if (kombi.isSelected()) {
            if (!wasSelected) {
                typ += " Typ = \"Kombi\"";
            } else {
                typ += " OR Typ = \"Kombi\"";
            }
            wasSelected = true;
        }
        if (transporter.isSelected()) {
            if (!wasSelected) {
                typ += " Typ = \"Transporter\"";
            } else {
                typ += " OR Typ = \"Transporter\"";
            }
            wasSelected = true;
        }
        if (limousine.isSelected()) {
            if (!wasSelected) {
                typ += " Typ = \"Limousine\"";
            } else {
                typ += " OR Typ = \"Limousine\"";
            }
            wasSelected = true;
        }

        subCommand += marke;
        if (marke.length() > 0 && sitze.length() > 0) {
            subCommand += " AND" + sitze;
        } else {
            subCommand += sitze;
        }

        if (sitze.length() > 0 && typ.length() > 0) {
            subCommand += " AND" + typ;
        } else if (marke.length() > 0 && typ.length() > 0) {
            subCommand += " AND" + typ;
        } else {
            subCommand += typ;
        }

        if (subCommand.length() > 0) {
            sqlCommand += " WHERE" + subCommand;
        }

        if (tagessatz.length() > 0) {
            sqlCommand += tagessatz;
        }

        data.update(AUTO, sqlCommand);
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

        if (data.getPassword().equals("Gast")) {
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
