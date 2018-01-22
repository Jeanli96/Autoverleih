/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Kunde;
import Data.Data;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author klemens
 */
public class EditCustomerStage extends Stage {

    static public EditCustomerStage stage;

    public EditCustomerStage(Data data, Kunde selectedKunde) throws IOException {

        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditCustomer.fxml"));
        AnchorPane anchorPane = loader.load();
        
        EditCustomerController controller = loader.getController();
        controller.setStage(selectedKunde);
        controller.setData(data);
        Scene scene = new Scene(anchorPane);
       
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
