
package com.mycompany.healthcaremanagementsystem;

import Model.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author sahil
 */
public class UpdatePatientController implements Initializable {


    @FXML
    private MenuButton genderMenu;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private DatePicker dateOfBirthField;
    @FXML
    private TextField medicareCardField;
    @FXML
    private Text error;
    @FXML
    private TextArea medicalHistoryField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void genderMenuEvent(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selected = selectedItem.getText();
        genderMenu.setText(selected);
    }

    @FXML
    private void updatePatientBtn(ActionEvent event) {
            String firstName = firstnameField.getText();
            String lastName = lastnameField.getText();
            String gender = genderMenu.getText();
            java.sql.Date dateOfBirth= null;
            String address = addressField.getText();
            String contactNumber = contactNumberField.getText();
            String medicareCard = medicareCardField.getText();
            String medicalhistory = medicalHistoryField.getText();
            
        if(firstName.isBlank())
        {
            showError(true, "Firstname is required!");
        }
        else if(lastName.isBlank())
        {
            showError(true, "LastName is required!");
        }
        else if(gender.isBlank() || gender.compareTo("Select Gender") == 0)
        {
            showError(true, "Please select a gender");
        }
        else if(dateOfBirthField.getValue() == null)
        {
            showError(true, "Please select date of birth");
        }
        else if(address.isBlank())
        {
            showError(true, "Address is required");
        }
        else if(contactNumber.isBlank())
        {
            showError(true, "Contactnumber is required");
        }
        else if(medicareCard.isBlank())
        {
            showError(true, "Medicare Card Number is required");
        }
        else if(medicalhistory.isBlank())
        {
            showError(true, "Medical History is required");
        }
        else{
             showError(false, "");
             dateOfBirth = java.sql.Date.valueOf(dateOfBirthField.getValue());
             
             // create new patient
             Patient p = new Patient(App.getSearchedPatient().getPatientId(), firstName, lastName, gender, dateOfBirth, address, contactNumber, medicareCard, medicalhistory);
             App.getDb().updatePatientByID(p);
             
              // show the success message
            
            // Display a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Health Care Management System");
            alert.setHeaderText("Success");
            alert.setContentText("A New Patient has been Updated");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                }
            });

        }
    }

    private void homeBtn(ActionEvent event) {
        App.switchScene("medicalStaffHome.fxml");
    }

    @FXML
    private void logoutBtn(ActionEvent event) {
        App.switchScene("loginPage.fxml");
    }

    public MenuButton getGenderMenu() {
        return genderMenu;
    }

    public TextField getFirstnameField() {
        return firstnameField;
    }

    public TextField getLastnameField() {
        return lastnameField;
    }

    public TextField getAddressField() {
        return addressField;
    }

    public TextField getContactNumberField() {
        return contactNumberField;
    }

    public DatePicker getDateOfBirthField() {
        return dateOfBirthField;
    }

    public TextField getMedicareCardField() {
        return medicareCardField;
    }

    public Text getError() {
        return error;
    }

    public TextArea getMedicalHistoryField() {
        return medicalHistoryField;
    }
    
    public void showError(boolean e,String msg)
    {
        error.setText(msg);
        error.setVisible(e);
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
