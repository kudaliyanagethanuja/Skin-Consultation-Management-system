package cw;

import cw.Doctor;
import cw.SkinConsultationManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    //Array to hold the objects of doctor class
    private Doctor[] doctors = new Doctor[10];

    private Scanner scanner = new Scanner(System.in);

    @Override
    //Menu to ADD, DELETE, LIST and SAVE doctors
    public int menu() {
        System.out.print("" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n" +
                "Menu........" +
                "        \n\n" +
                "  1   >  ADD DOCTOR         \n" +
                "  2   > DELETE DOCTOR      \n" +
                "  3   >  LIST DOCTORS       \n" +
                "  4   >  SAVE DOCTORS       \n" +
                "  9   >  Exit  " +
                "             \n" +
                "______________________________\n" +
                " Enter Your CHOICE : ");
        return scanner.nextInt();
    }

    //Add cw.Doctor User Inputs
    public void addDoctorUserInputs(){
        //Prompting for Name
        System.out.print("Please enter the first name : ");
        String name = scanner.next();

        //Prompting for the Surname
        System.out.print("Please enter the last name : ");
        String surname = scanner.next();

        //Prompting for DOB
        String dateOfBirth;
        while (true) {
            System.out.print("Please enter the Date of Birth [dd/MM/yyyy] : ");
            dateOfBirth = scanner.next();
            if (validateDOB(dateOfBirth)){
                break;
            }
        }

        //Prompting for the Mobile Number
        String mobileNumber;
        while (true) {
            System.out.print("Please enter the mobile number : ");
            mobileNumber = scanner.next();
            if (validatePhone(mobileNumber)){
                break;
            }
        }

        //Prompting for the Medical License Number
        System.out.print("Please enter the Medical License Number : ");
        int medicalLicenseNumber = scanner.nextInt();

        //Prompting for the specialization
        System.out.print("Please enter the Specialization: ");
        String specialisation = scanner.next();

        //calling add doctor method
        addDoctor(name,surname,dateOfBirth,mobileNumber,medicalLicenseNumber,specialisation);
    }

    @Override
    public void addDoctor(String name, String surname, String dateOfBirth, String mobileNumber, int medicalLicenseNumber, String specialisation) {

        for (int i = 0; i < doctors.length; i++){
            if (doctors[i] == null){
                Doctor newDoctor = new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenseNumber,specialisation);
                doctors[i] = newDoctor;
                log(true,"Doctor added Successfully");
                break;
            }else if(i == doctors.length-1){
                log(false,"Maximum number of doctors are already added.");
            }
        }
    }


    public int deleteDoctorUserInput(){
        //Prompting for the medical License Number
        System.out.print("Please enter the medical License Number : ");
        int licenseNumber = scanner.nextInt();
        return licenseNumber;
    }

    @Override
    public void deleteDoctor(int licenseNumber) {
        //cw.Doctor Count
        int count = 0;
        boolean found = false;      //boolean variable to confirm if the doctor found with the matching Medical License Number
        for (int i = 0; i < doctors.length; i++){
            if (doctors[i] != null) {
                if (doctors[i].getMedicalLicenseNumber() == licenseNumber) {
                    System.out.println(doctors[i].toString());
                    doctors[i] = null;
                    found = true;
                    log(true, "Doctor deleted Successfully");
                }else {
                    count++;
                }
            }else if ((i == doctors.length - 1) && !found) {
                log(false, "Medical License Number Not Found. Please reEnter number");
            }
        }
        System.out.println("Total Doctors Count : "+count);
    }

    @Override
    public ArrayList<Doctor> listDoctors() {
        //ArrayList to hold sorted doctors
        ArrayList<Doctor> doctorArrayList = new ArrayList<>();

        //populating sorted doctor array
        log(true, "Started populating doctorArrayList");
        //Populating the arraylist while skipping the nulls
        for(Doctor doctor : doctors){
            if (doctor != null){
                doctorArrayList.add(doctor);
            }
        }
        log(true, "Completed populating doctorArrayList");


        if (doctorArrayList.isEmpty()){
           log(false,"ArrayList for sorting doctors empty");
           return null;
        }else {


            log(true, "Started Sorting");
            //Sorting
            for (int i = 0; i < doctorArrayList.size() - 1; i++) {
                for (int j = i + 1; j < doctorArrayList.size(); j++) {
                    if (doctorArrayList.get(i).getSurname().compareToIgnoreCase(doctorArrayList.get(j).getSurname()) > 0) {
                        Doctor temp = doctorArrayList.get(i);
                        doctorArrayList.set(i, doctorArrayList.get(j));
                        doctorArrayList.set(j, temp);
                    }
                }
            }
            log(true, "Completed sorting");
            return doctorArrayList;
        }
    }

    public void printSortedDoctors(ArrayList<Doctor> doctorArrayList){
        if (doctorArrayList != null) {
            log(true, "Started Logging");
            for (Doctor doctor : doctorArrayList) {
                System.out.println(doctor.toString());
            }
            log(true, "Logging Completed");
        }
    }

    @Override
    public void saveInfo() throws IOException {
        File file = new File("DoctorStore.txt");
        log(true,"File : "+file.getName() + " ready to store data.");
        FileWriter writer = new FileWriter(file);
        for (Doctor doctor : doctors){
            if (doctor != null){
                writer.write(doctor.getName()+
                        ","+doctor.getSurname()+
                        ","+doctor.getDateOfBirth()+
                        ","+doctor.getMobileNumber()+
                        ","+doctor.getMedicalLicenseNumber()+
                        ","+doctor.getSpecialisation()+"\n");
            }else {
                writer.write("null\n");
            }
        }
        writer.close();
        log(true,"Saving data to file : "+ file.getName()+ " Complete");
    }

    @Override
    public void loadInfo() throws FileNotFoundException {
        File file = new File("DoctorStore.txt");
        Scanner reader = new Scanner(file);
        int index = 0;
        while (reader.hasNextLine()){
            String readerInfo = reader.nextLine();
            if (!readerInfo.equalsIgnoreCase("null")) {
                String[] readerInfoArray = readerInfo.split(",");
                doctors[index] = new Doctor(readerInfoArray[0],readerInfoArray[1],readerInfoArray[2],readerInfoArray[3],Integer.parseInt(readerInfoArray[4]),readerInfoArray[5]);
            }else {
                doctors[index] = null;
            }
            index++;
        }
        reader.close();
    }

    public void log(boolean status , String msg){
        if (status){
            System.out.println("<< INFO >> "+ msg);
        }else {
            System.out.println("<< ERROR >> "+ msg);
        }
    }

    private boolean validateDOB(String dob){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            simpleDateFormat.parse(dob);
        }catch (ParseException e){
            log(false,"Please follow the correct format");
            return false;
        }
        return true;
    }

    private boolean validatePhone(String number){
        if (number.length() == 10){
            try {
                Integer.parseInt(number);
                return true;
            }catch (NumberFormatException e){
                log(false,"Please enter only numbers for the phone number");
                return false;
            }
        }else {
            log(false,"Phone number should contain 10 numbers");
            return false;
        }
    }

    public Doctor[] getDoctors() {
        return doctors;
    }
}
