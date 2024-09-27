package MedCheck.dao.impl;

import MedCheck.dao.HospitalDao;
import MedCheck.databasse.DataBase;
import MedCheck.models.Hospital;
import MedCheck.models.Patient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
   private final DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        dataBase.hospitals.add(hospital);
        return "Successfully added";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)){
                return hospital;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
       return dataBase.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)){
                return hospital.getPatients();
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        Iterator<Hospital> iterator = dataBase.hospitals.iterator();
        while (iterator.hasNext()){
            Hospital next = iterator.next();
            if (next.getId().equals(id)){
                return "Successfully deleted: "+id;
            }
        }
        return  "Hospital with ID: " + id + " not found";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalMap = new HashMap<>();
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getAddress().equals(address)) {
                hospitalMap.put(hospital.getHospitalName(), hospital);
            }
        }
        return hospitalMap.isEmpty() ? null : hospitalMap;
    }
}
