package GUI;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GPope
 */
public class NewContractStage extends Stage{
    Stage stage;

    public NewContractStage() throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("NewContract.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    
}
