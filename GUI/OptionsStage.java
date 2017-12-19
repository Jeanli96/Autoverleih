/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class OptionsStage extends Stage {

    private Stage stage;

    public OptionsStage(FXMLMain fmain, Stage fstage) throws IOException {
        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Options.fxml"));
        AnchorPane anchorPane = loader.load();
        
        OptionsController controller = loader.getController();
        controller.setMain(fmain);
        controller.setMStage(fstage);
        Scene scene = new Scene(anchorPane);
       
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
