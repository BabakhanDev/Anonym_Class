package MedCheck.dao;

import MedCheck.models.Doctor;

import java.util.List;

public interface DoctorDao {
    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып
    // анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз

    Doctor findDoctorById(Long id);
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
