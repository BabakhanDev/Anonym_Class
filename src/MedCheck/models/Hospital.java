package MedCheck.models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Long hospitalId;
    private String hospitalName;
    private String address;
    private List<Department> departments =new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital() {
    }

    public Hospital(Long hospitalId, String hospitalName, String address) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public Hospital(Long hospitalId, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getId() {
        return hospitalId;
    }

    public void setId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "\nHospital{" +
                "id=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}'+"\n";
    }
}
