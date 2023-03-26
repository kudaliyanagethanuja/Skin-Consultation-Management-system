package cw;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;

public class Consultation {
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private int cost;
    private String notes;

    //Constructor
    public Consultation(Doctor doctor, Patient patient, Date date, int cost, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.cost = cost;
        this.notes = notes;
    }

    //Getters and Setters
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
