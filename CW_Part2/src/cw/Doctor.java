package cw;

public class Doctor extends Person {

    private int medicalLicenseNumber;
    private String specialisation;

    //Constructor
    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, int medicalLicenseNumber, String specialisation) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialisation = specialisation;
    }

    //To String
    @Override
    public String toString() {
        return  "\nFirst Name : "+ super.getName() +
                "\nSurname : " + super.getSurname() +
                "\nDOB : " + super.getDateOfBirth() +
                "\nMobile No : " + super.getMobileNumber()+
                "\nMedical License Number : " + medicalLicenseNumber +
                "\nSpecialisation : " + specialisation;
    }

    //Getters and Setters
    public int getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(int medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


}
