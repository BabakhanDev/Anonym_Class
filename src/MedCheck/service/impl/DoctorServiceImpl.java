package MedCheck.service.impl;

import MedCheck.dao.impl.DoctorDaoImpl;
import MedCheck.models.Doctor;
import MedCheck.service.DoctorService;
import MedCheck.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements GenericService<Doctor>, DoctorService {
private final DoctorDaoImpl doctorDao;

    public DoctorServiceImpl(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        doctorDao.add(hospitalId,doctor);
        return "Successfully added: ";
    }

    @Override
    public void removeById(Long doctorId) {
        doctorDao.removeById(doctorId);

    }

    @Override
    public String updateById(Long doctorId, Doctor doctor) {
        doctorDao.updateById(doctorId,doctor);
        return "Successfully Updated: ;";
    }
    @Override
    public Doctor findDoctorById(Long doctorId) {
       return doctorDao.findDoctorById(doctorId);

    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
        return "Successfully Assigned: ;";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long hospitalId) {
        return doctorDao.getAllDoctorsByHospitalId(hospitalId);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long departId) {
        return doctorDao.getAllDoctorsByDepartmentId(departId);
    }

}
