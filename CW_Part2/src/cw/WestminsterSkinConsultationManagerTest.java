package cw;

import cw.Doctor;
import cw.WestminsterSkinConsultationManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {

    @Test
    void addDoctor() {
        WestminsterSkinConsultationManager wscm = new WestminsterSkinConsultationManager();
        wscm.addDoctor("Tom","Luce","01/10/1970","0772134665",123789,"paediatric");

        //Testing the variables of the added doctors
        //Name
        assertEquals("Tom",wscm.getDoctors()[0].getName());
        //Surname
        assertEquals("Luce",wscm.getDoctors()[0].getSurname());
        //date of birth
        assertEquals("01/10/1970",wscm.getDoctors()[0].getDateOfBirth());
        //mobile Number
        assertEquals("0772134665",wscm.getDoctors()[0].getMobileNumber());
        //Medical License Number
        assertEquals(123789,wscm.getDoctors()[0].getMedicalLicenseNumber());
        //Specialisation
        assertEquals("paediatric",wscm.getDoctors()[0].getSpecialisation());
    }

    @Test
    void deleteDoctor() {
        WestminsterSkinConsultationManager wscm = new WestminsterSkinConsultationManager();
        wscm.addDoctor("Tom","Luce","01/10/1970","0772134665",123789,"paediatric");

        //Expected Result
        Doctor[] doctors = new Doctor[10];

        wscm.deleteDoctor(123789);
        assertArrayEquals(doctors,wscm.getDoctors());
    }

    @Test
    void listDoctors() {
        //Obj of WestminsterSkinConsultationManager1
        WestminsterSkinConsultationManager wscm = new WestminsterSkinConsultationManager();
        //Populating doctors
        wscm.addDoctor("Tom","Luce","01/10/1970","0772134665",123789,"paediatric");
        wscm.addDoctor("Ann","Ander","17/02/1990","0774532146",459325,"paediatric");
        wscm.addDoctor("Jude","Stone","11/09/2000","0741593264",782319,"paediatric");

        //Actual Result
        ArrayList<Doctor> actualResult = wscm.listDoctors();

        //Expected Result
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Ander");
        expectedResult.add("Luce");
        expectedResult.add("Stone");

        assertEquals(expectedResult.get(0),actualResult.get(0).getSurname());
        assertEquals(expectedResult.get(1),actualResult.get(1).getSurname());
        assertEquals(expectedResult.get(2),actualResult.get(2).getSurname());
    }
}