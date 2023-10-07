
package Model;

/**
 *
 * @author sahil
 */
public class Queries {
    
    public static String DROP_DATABASE = "DROP DATABASE IF EXISTS healthlink;";
    public static String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS healthlink;";
    
    public static String USER_TABLE = "CREATE TABLE User (\n" +
                                        "    UserID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                        "    FirstName VARCHAR(50) NOT NULL,\n" +
                                        "    LastName VARCHAR(50) NOT NULL,\n" +
                                        "    Gender VARCHAR(20),\n" +
                                        "    DateOfBirth DATE,\n" +
                                        "    EmailAddress VARCHAR(100),\n" +
                                        "    Password VARCHAR(255) NOT NULL,\n" +
                                        "    Role VARCHAR(20) NOT NULL\n" +
                                        ");";
    public static String USER_TABLE_AUTO_INCREMENT = "ALTER TABLE User AUTO_INCREMENT = 1000001;";
    
    public static String SELECT_USER_BY_ID = "SELECT * FROM User WHERE UserID = ?";
    public static String SELECT_USER_BY_EMAIL = "SELECT * FROM User WHERE EmailAddress = ?";

    
    
    public static String INSERT_INTO_USER = "INSERT INTO User (FirstName, LastName, Gender, DateOfBirth, EmailAddress, Password, Role)\n" +
                                            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    
            public static String PATIENT_TABLE = "CREATE TABLE Patient (\n" +
                "    patientid INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    FirstName VARCHAR(50) NOT NULL,\n" +
                "    LastName VARCHAR(50) NOT NULL,\n" +
                "    Gender VARCHAR(20),\n" +
                "    DateOfBirth DATE,\n" +
                "    EmailAddress VARCHAR(100),\n" +
                "    Password VARCHAR(255) NOT NULL,\n" +
                "    MedicalHistory TEXT,\n" +
                "    Allergies TEXT\n" +  // Remove the extra comma here
                ");";
    public static String PATIENT_TABLE_AUTO_INCREMENT = "ALTER TABLE Patient AUTO_INCREMENT = 2000001;";

    
    public static String MEDICAL_STAFF_TABLE = "CREATE TABLE MedicalStaff (\n" +
                                                "    StaffID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                                "    FirstName VARCHAR(50) NOT NULL,\n" +
                                                "    LastName VARCHAR(50) NOT NULL,\n" +
                                                "    Gender VARCHAR(20),\n" +
                                                "    DateOfBirth DATE,\n" +
                                                "    EmailAddress VARCHAR(100),\n" +
                                                "    Password VARCHAR(255) NOT NULL,\n" +
                                                "    Specialty VARCHAR(50),\n" +
                                                "    WorkingSchedule TEXT\n" +
                                                ");";
    public static String MEDICAL_STAFF_TABLE_AUTO_INCREMENT = "ALTER TABLE MedicalStaff AUTO_INCREMENT = 3000001;";
    
    public static String APPOINTMENT_TABLE = "CREATE TABLE Appointment (\n" +
                                            "    AppointmentID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                            "    PatientID INT,\n" +
                                            "    HealthcareProviderID INT,\n" +
                                            "    AppointmentDate DATE,\n" +
                                            "    AppointmentTime TIME,\n" +
                                            "    Purpose TEXT,\n" +
                                            "    Status VARCHAR(20) DEFAULT 'Scheduled',\n" +
                                            "    FOREIGN KEY (PatientID) REFERENCES Patient(patientid),\n" +
                                            "    FOREIGN KEY (HealthcareProviderID) REFERENCES MedicalStaff(StaffID)\n" +
                                            ");";
    public static String APPOINTMENT_TABLE_AUTO_INCREMENT = "ALTER TABLE Appointment AUTO_INCREMENT = 4000001;";

    
    public static String BILLING_TABLE = "CREATE TABLE BillingInvoice (\n" +
                                        "    InvoiceID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                        "    PatientID INT,\n" +
                                        "    InvoiceDate DATE,\n" +
                                        "    DueDate DATE,\n" +
                                        "    TotalAmount DECIMAL(10, 2),\n" +
                                        "    PaymentStatus VARCHAR(20) DEFAULT 'Unpaid',\n" +
                                        "    PaymentMethod VARCHAR(50),\n" +
                                        "    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)\n" +
                                        ");";
    public static String BILLING_TABLE_AUTO_INCREMENT = "ALTER TABLE BillingInvoice AUTO_INCREMENT = 5000001;";

}
