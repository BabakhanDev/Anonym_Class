package MedCheck.dao.impl;

import MedCheck.dao.DoctorDao;
import MedCheck.dao.GenerciDao;
import MedCheck.databasse.DataBase;
import MedCheck.models.Department;
import MedCheck.models.Doctor;
import MedCheck.models.Hospital;

import java.util.Iterator;
import java.util.List;

public class DoctorDaoImpl implements GenerciDao<Doctor>, DoctorDao {
    private final DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                if (!hospital.getDoctors().contains(doctor)) {
                    hospital.getDoctors().add(doctor);
                    return "Doctor added successfully to hospital with ID: " + hospitalId;
                } else {
                    return "Doctor already in hospital with ID: " + hospitalId;
                }
            }
        }
        return "Hospital with ID: " + hospitalId + " not found";
    }

    @Override
    public void removeById(Long doctorId) {
        Iterator<Hospital> iterator = dataBase.hospitals.iterator();
        while (iterator.hasNext()) {
            Hospital hospital = iterator.next();
            if (hospital.getId().equals(doctorId)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                for (Doctor doctor1 : hospital.getDoctors()) {
                    if (doctor1.getDoctorId().equals(doctor.getDoctorId())) {
                        doctor1.setFirstName(doctor.getFirstName());
                        doctor1.setLastName(doctor.getLastName());
                        doctor1.setGender(doctor.getGender());
                        doctor1.setExperienceYear(doctor.getExperienceYear());
                        return "Doctor updated successfully";
                    }
                }
                return "Doctor with id " + doctor.getDoctorId() + " not found";
            }
        }
        return "Hospital with id " + id + " not found";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getDoctorId().equals(id)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {

        for (Hospital hospital : dataBase.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    for (Long l : doctorsId) {
                        for (Doctor doctor : hospital.getDoctors()) {
                            if (doctor.getDoctorId().equals(l)) {
                                department.getDoctors().add(doctor);
                            }
                        }
                    }
                    return "Doctor assigned to departament with id: " + departmentId;
                }
            }
        }
        return "Department with ID " + departmentId + " not found";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    return department.getDoctors();
                }
            }
        }
        return null;
    }
}
