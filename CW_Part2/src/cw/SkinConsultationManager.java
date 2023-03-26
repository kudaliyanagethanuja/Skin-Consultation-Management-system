package cw;

import cw.Doctor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {
    int menu();
    void addDoctor(String name, String surname, String dateOfBirth, String mobileNumber, int medicalLicenseNumber, String specialisation);
    void deleteDoctor(int licenseNumber);
    ArrayList<Doctor> listDoctors();
    void saveInfo() throws IOException;
    void loadInfo() throws FileNotFoundException;

}
