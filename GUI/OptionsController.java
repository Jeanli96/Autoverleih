/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Stream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class OptionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private FXMLMain fmain;
    private Stage stage;
    
    @FXML
    private TextField input;

    @FXML
    private void next() throws IOException {
        String holder = input.getText();
        
        if (holder.equals("") || holder.equals(null) || holder.equals(" "))
            holder = "Gast";
        
        new Stream().write(holder);
        
        fmain.stageShow(stage);
        Stage stagethis = (Stage) input.getScene().getWindow();
        stagethis.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setMain(FXMLMain fmain)
    {
       this.fmain = fmain; 
    }
    
    public void setMStage (Stage fstage)
    {
       this.stage = fstage; 
    }    
}
