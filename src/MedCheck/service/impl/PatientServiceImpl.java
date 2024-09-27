package MedCheck.service.impl;

import MedCheck.dao.impl.PatientDaoImpl;
import MedCheck.models.Patient;
import MedCheck.service.GenericService;
import MedCheck.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements GenericService<Patient>, PatientService {
    private final PatientDaoImpl patientDao;

    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        patientDao.add(hospitalId,patient);
        return "Successfully added: ";
    }

    @Override
    public void removeById(Long id) {
        patientDao.removeById(id);

    }

    @Override
    public String updateById(Long id, Patient patient) {
        patientDao.updateById(id,patient);
        return "Successfully Updated: ";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        patientDao.addPatientsToHospital(id,patients);
        return "Successfully added Patients to Hospital: ";
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
