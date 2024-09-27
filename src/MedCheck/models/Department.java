package MedCheck.models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long departmentId;
    private String departmentName;
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {
    }

    public Department(Long departmentId, String departmentName, List<Doctor> doctors) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }

    public Department(long l, String терапия) {

    }

    public Long getId() {
        return departmentId;
    }

    public void setId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "id=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}'+"\n";
    }
}
