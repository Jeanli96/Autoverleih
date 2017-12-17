/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Auto;
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
    private Auto selectedAuto;

    public EditCarStage(Auto selectedAuto) throws IOException {
        this.selectedAuto = selectedAuto;

        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditCar.fxml"));
        AnchorPane anchorPane = loader.load();
        
        EditCarController controller = loader.getController();
        controller.setStage(selectedAuto);
        Scene scene = new Scene(anchorPane, 360, 292);
       
        stage.setScene(scene);
        stage.show();
    }

    public Auto getAuto() {
        return selectedAuto;
    }
}
