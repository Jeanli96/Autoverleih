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
public class EditCarStage extends Stage {

    static public EditCarStage stage;
    private Auto selectedAuto;

    public EditCarStage(Auto selectedAuto) throws IOException {
        this.selectedAuto = selectedAuto;

        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("EditCar.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public Auto getAuto() {
        return selectedAuto;
    }
}
