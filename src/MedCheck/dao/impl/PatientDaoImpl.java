package MedCheck.dao.impl;

import MedCheck.dao.GenerciDao;
import MedCheck.dao.PatientDao;
import MedCheck.databasse.DataBase;
import MedCheck.models.Hospital;
import MedCheck.models.Patient;

import java.util.*;

public class PatientDaoImpl implements GenerciDao<Patient>, PatientDao {
    private final DataBase dataBase;

    public PatientDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getPatients().add(patient);
                return " Successfully added" + hospitalId;
            }
        }
        return "not found: " + hospitalId;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                dataBase.hospitals.remove(hospital);
                System.out.println(" Hospital Removed successfully ");
                break;
            }
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                for (Patient hospitalPatient : hospital.getPatients()) {
                    if (hospitalPatient.getPatientId().equals(patient.getPatientId())) {
                        hospitalPatient.setFirstName(patient.getFirstName());
                        hospitalPatient.setLastName(patient.getLastName());
                        hospitalPatient.setAge(patient.getAge());
                        hospitalPatient.setGender(patient.getGender());
                        return "Patient updated successfully";
                    }
                }
                return "Patient with id " + patient.getPatientId() + " not found";
            }
        }
        return "Hospital with id " + id + " not found";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)) {
                hospital.getPatients().addAll(patients);
                return "Patient added successfully to hospital with ID: " + id;
            }
        }
        return "Hospital with ID: " + id + " not found";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getPatientId().equals(id)) {
                    return patient;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> map = new HashMap<>();
        for (Hospital hospital : dataBase.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                map.put(patient.getAge(), patient);
            }
        }
        return map;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : dataBase.hospitals) {
            patients.addAll(hospital.getPatients());
        }
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            patients.sort(Comparator.comparingInt(Patient::getAge));
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            patients.sort(Comparator.comparingInt(Patient::getAge).reversed());
        }
        return patients;
    }
}






