
package com.mycompany.healthcaremanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author sahil
 */
public class ViewBillController implements Initializable {


    @FXML
    private Text patientNameLabel;
    @FXML
    private TextArea billArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void logOutEvent(ActionEvent event) {
        App.switchScene("loginPage.fxml");
    }

    public TextArea getBillArea() {
        return billArea;
    }

    public Text getPatientNameLabel() {
        return patientNameLabel;
    }

    @FXML
    private void addPatientEvent(ActionEvent event) {
        App.switchScene("addNewPatient.fxml");
    }

    @FXML
    private void updatePatientEvent(ActionEvent event) {
        App.switchScene("searchPatient.fxml");
    }

    @FXML
    private void scheduleAppointmentEvent(ActionEvent event) {
        App.switchScene("bookAppointment.fxml");
    }

    @FXML
    private void viewBillsEvent(ActionEvent event) {
        App.switchScene("searchPatientBill.fxml");
    }

    @FXML
    private void viewAnalyticsDashboardEvent(ActionEvent event) {
        App.switchScene("viewAnalytics.fxml");
    }
    
}
