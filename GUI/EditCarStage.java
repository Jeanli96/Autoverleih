/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
import Data.Data;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class EditCarStage extends Stage {

    static public EditCarStage stage;

    public EditCarStage(Auto selectedAuto, Data data) throws IOException {

        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditCar.fxml"));
        AnchorPane anchorPane = loader.load();
        
        EditCarController controller = loader.getController();
        controller.setStage(selectedAuto);
        controller.setData(data);
        Scene scene = new Scene(anchorPane);
       
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
