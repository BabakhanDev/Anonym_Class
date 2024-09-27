package MedCheck.service.impl;

import MedCheck.dao.impl.HospitalDaoImpl;
import MedCheck.models.Hospital;
import MedCheck.models.Patient;
import MedCheck.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    private  final HospitalDaoImpl hospitalDao;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
        return "Successfully added: ";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.deleteHospitalById(id);
        return "Successfully Deleted: ";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
