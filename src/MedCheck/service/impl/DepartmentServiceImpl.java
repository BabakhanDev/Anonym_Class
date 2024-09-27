package MedCheck.service.impl;

import MedCheck.dao.impl.DepartmentDaoImpl;
import MedCheck.models.Department;
import MedCheck.service.DepartmentService;
import MedCheck.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements GenericService<Department> , DepartmentService {

    private  final DepartmentDaoImpl departmentDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        departmentDao.add(hospitalId,department);
        return "Successfully added: ";
    }

    @Override
    public void removeById(Long departmentId) {
        departmentDao.removeById(departmentId);

    }

    @Override
    public String updateById(Long departmentId, Department department) {
        departmentDao.updateById(departmentId,department);
        return "Successfully Updated: ";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long hospitalId) {
        return departmentDao.getAllDepartmentByHospital(hospitalId);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }
}
