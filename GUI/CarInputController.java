/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Data;
import Data.Vertrag;
import Data.VertragQuery;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class CarInputController implements Initializable {

    private Data data;

    @FXML
    private Button abbruch, bestaetigen, searchKennzeichen, searchVertrag;
    @FXML
    private Text abtermin, datum;
    @FXML
    private TextField kennzeichen, vertrag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void search(ActionEvent event) {
        final Stage searchList = new Stage();
        searchList.initModality(Modality.WINDOW_MODAL);
        Button ok = new Button("OK");
        Button cancel = new Button("Abbruch");
        ListView listView = new ListView();

        Vertrag[] vertraege = data.getCarInput();
        if (vertraege != null) {
            String[] holder = new String[vertraege.length];

            for (int i = 0; i < vertraege.length; i++) {
                holder[i] = "Nr.: " + vertraege[i].getVertragsID() + " | " + vertraege[i].getKennzeichen() + " | " + new VertragQuery().getKundenName(vertraege[i].getKundenID(), data.getPassword());
            }

            ObservableList<String> daten = FXCollections.observableArrayList(holder);
            listView.setItems(daten);
        }

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                int i = listView.getSelectionModel().getSelectedIndex();

                vertrag.setText("" + vertraege[i].getVertragsID());
                kennzeichen.setText(vertraege[i].getKennzeichen());

                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Calendar c = df.getCalendar();
                c.setTimeInMillis(System.currentTimeMillis());
                datum.setText(c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR));
                
                c = df.getCalendar();
                c.setTime(vertraege[i].getRueckgabetermin());
                abtermin.setText(c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR));

                data.fullUpdate();
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
    private void buttonBestaetigen() {
        
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());                
        
        new VertragQuery().editTatAbholtermin(Integer.parseInt(vertrag.getText()), c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH));
        
        buttonAbbruch();
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
