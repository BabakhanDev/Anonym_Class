package MedCheck.dao.impl;

import MedCheck.dao.DepartmentDao;
import MedCheck.dao.GenerciDao;
import MedCheck.databasse.DataBase;
import MedCheck.models.Department;
import MedCheck.models.Hospital;

import java.util.Iterator;
import java.util.List;

public class DepartmentDaoImpl implements GenerciDao<Department>, DepartmentDao {
    private final DataBase dataBase;

    public DepartmentDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(hospitalId)){
                hospital.getDepartments().add(department);
                return "Successfully added: ";
            }
        }
        return "Not Found: ";
    }

    @Override
    public void removeById(Long departId) {
        Iterator<Hospital> iterator = dataBase.hospitals.iterator();
        while (iterator.hasNext()){
            Hospital hospital = iterator.next();
            if (hospital.getId().equals(departId)){
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public String updateById(Long id, Department department) {
        for (Hospital hospital : dataBase.hospitals) {
          if (hospital.getId().equals(id)){
              for (Department dep : hospital.getDepartments()) {
                  if (dep.getId().equals(department.getId())){
                      dep.setDepartmentName(department.getDepartmentName());
                      dep.setDoctors(department.getDoctors());
                      return "Department name updated successfully";
                  }
              }
              return "Department with id " + department.getId() + " not found";
          }
        }
        return "Hospital with id " + id + " not found";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : dataBase.hospitals) {
            if (hospital.getId().equals(id)){
                return hospital.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : dataBase.hospitals) {
            System.out.println("Check hospital: " + hospital.getHospitalName());
            for (Department department : hospital.getDepartments()) {
                System.out.println("Check department: " + department.getDepartmentName());
                if (department.getDepartmentName().equalsIgnoreCase(name)){
                    return department;

                }
            }
        }
        return null;
    }
}
