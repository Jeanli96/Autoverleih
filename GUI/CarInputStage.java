/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Data;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class CarInputStage extends Stage {
    
    private Stage stage; 

    public CarInputStage(Data data) throws IOException  {
        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CarInput.fxml"));
        AnchorPane anchorPane = loader.load();
        
        CarInputController controller = loader.getController();
        controller.setData(data);
        Scene scene = new Scene(anchorPane);
       
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
