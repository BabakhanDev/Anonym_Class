package MedCheck.models;

import MedCheck.models.enums.Gender;

public class Doctor {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int experienceYear;

    public Doctor() {
    }

    public Doctor(Long doctorId, String firstName, String lastName, Gender gender, int experienceYear) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    @Override
    public String toString() {
        return "\nDoctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", experienceYear=" + experienceYear +
                '}'+"\n";
    }
}
