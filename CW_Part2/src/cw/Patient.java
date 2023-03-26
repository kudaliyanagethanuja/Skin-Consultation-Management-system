package cw;

public class Patient extends Person {

    //cw.Patient unique ID
    private Long id;

    //Constructor
    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, Long id) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.id = id;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
