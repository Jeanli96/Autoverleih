/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class NewCarStage extends Stage {

    private Stage stage;    

    public NewCarStage() throws IOException {
        
        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("NewCar.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
