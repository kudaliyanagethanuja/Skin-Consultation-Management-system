package cw;

import java.io.IOException;

public class Main {

    private static final WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
    //Variable to manage the main loop
    private static boolean runMainLoop = true;

    public static void main(String[] args) throws IOException {
        westminsterSkinConsultationManager.log(true,"Loading Data");
        westminsterSkinConsultationManager.loadInfo();
        while (runMainLoop) {
            int choice = westminsterSkinConsultationManager.menu();
            methodManager(choice);
        }
    }

    public static void methodManager(int choice) throws IOException {
        switch (choice) {
            case 1:
                westminsterSkinConsultationManager.addDoctorUserInputs();
                break;
            case 2:
                westminsterSkinConsultationManager.deleteDoctor(westminsterSkinConsultationManager.deleteDoctorUserInput());
                break;
            case 3:
                westminsterSkinConsultationManager.printSortedDoctors(westminsterSkinConsultationManager.listDoctors());
                break;
            case 4:
                westminsterSkinConsultationManager.saveInfo();
                break;
            case 9:
                runMainLoop = false;
                westminsterSkinConsultationManager.log(true,"Quiting............\nThank You.");
                break;
            default:
                westminsterSkinConsultationManager.log(false, "Please enter a valid input.");
                break;
        }

    }
}
