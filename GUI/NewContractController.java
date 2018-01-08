package GUI;

import Data.Auto;
import Data.Data;
import Data.Datenbank;
import Data.Vertrag;
import Data.VertragQuery;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pdf.PDFCreator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dennis Jungmichel
 */
public class NewContractController implements Initializable {

    @FXML
    private Button anlegen;
    @FXML
    private Button abbruch;
    @FXML
    private Button carList, customerList;

    private Data data;

    @FXML
    private TextField customerNo;
    @FXML
    private TextField kennzeichen;
    @FXML
    private TextField secondDriver;
    @FXML
    private DatePicker pickupDate;
    @FXML
    private DatePicker returnDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	customerNo.setEditable(false);
    	kennzeichen.setEditable(false);
    }

    @FXML
    public void search(ActionEvent event) {
        final Stage searchList = new Stage();
        searchList.initModality(Modality.WINDOW_MODAL);
        Button ok = new Button("OK");
        Button cancel = new Button("Abbruch");
        ListView listView = new ListView();

        if (event.getSource() == carList) {
            ObservableList<String> daten = FXCollections.observableArrayList(data.getText(Datenbank.AUTO, true));
            listView.setItems(daten);
        } else {
            ObservableList<String> daten = FXCollections.observableArrayList(data.getText(Datenbank.KUNDE, true));
            listView.setItems(daten);
        }

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                int i = listView.getSelectionModel().getSelectedIndex();

                if (event.getSource() == carList) {
                    kennzeichen.setText(data.getKennzeichen(i, true));
                } else {
                    customerNo.setText("" + data.getKundenID(i, true));
                }

                searchList.close();
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                searchList.close();
            }
        });

        HBox hbox = new HBox(2);
        hbox.getChildren().addAll(ok, cancel);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(15));

        VBox vbox = new VBox(2);
        vbox.getChildren().addAll(listView, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        searchList.setScene(new Scene(vbox));
        searchList.show();
    }

    @FXML
    private void buttonAnlegen() {
        Date pDate, rDate;
        try {
            pDate = Date.valueOf(pickupDate.getValue());
            rDate = Date.valueOf(returnDate.getValue());
            
            
            data.hasCarTime(kennzeichen.getText(), pDate, rDate);

            if (pDate.before(rDate)) {
                String holder;
                if (secondDriver != null) {
                    holder = secondDriver.getText();
                } else {
                    holder = "kein Eintrag";
                }

                Vertrag neuerVertrag = new Vertrag(data.getNextVID(), Integer.parseInt(customerNo.getText()), kennzeichen.getText(), holder, pDate, rDate, null, null);
                new VertragQuery().write(neuerVertrag);
                
                //PDFCreator pdfc = new PDFCreator(neuerVertrag, data);
                //pdfc.ausfuehren();

                data.fullUpdate();
                buttonAbbruch();
            } else {
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
                vbox.getChildren().addAll(new Text("Der Abholtermin muss vor dem Rueckgabetermin liegen."), ok);
                vbox.setAlignment(Pos.CENTER);
                vbox.setPadding(new Insets(15));

                dialogStage.setScene(new Scene(vbox));
                dialogStage.show();
            }
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
            vbox.getChildren().addAll(new Text(e.getMessage()), ok);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        
        } catch (Exception ex) {
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
            vbox.getChildren().addAll(new Text("Felerhafte Eingabe. Bitte die angegebenen Daten Ueberpruefen."), ok);
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
    
    public void setData(Data data)
    {
        this.data = data;
    }

}
