
package com.mycompany.healthcaremanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author sahil
 */
public class adminHomeController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void createNewUserEvent(ActionEvent event) throws IOException {
        App.switchScene("createNewUser.fxml");
    }

    @FXML
    private void modifyUserEvent(ActionEvent event) throws IOException {
        App.switchScene("searchUser.fxml");
    }

    @FXML
    private void logoutEvent(ActionEvent event) {     
        App.switchScene("loginPage.fxml");
        
    }

}
