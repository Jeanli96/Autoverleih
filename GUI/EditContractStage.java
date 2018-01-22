package GUI;


import Data.Data;
import Data.Vertrag;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
public class EditContractStage extends Stage{
    private Stage stage;

    public EditContractStage(Data data, Vertrag vertrag) throws IOException {
        stage = this;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditContract.fxml"));
        AnchorPane anchorPane = loader.load();
        
        EditContractController controller = loader.getController();
        controller.setData(data, vertrag);
        Scene scene = new Scene(anchorPane);
       
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
}
