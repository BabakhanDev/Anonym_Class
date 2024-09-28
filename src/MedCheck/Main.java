package MedCheck;

import MedCheck.dao.impl.DepartmentDaoImpl;
import MedCheck.dao.impl.DoctorDaoImpl;
import MedCheck.dao.impl.HospitalDaoImpl;
import MedCheck.dao.impl.PatientDaoImpl;
import MedCheck.databasse.DataBase;
import MedCheck.models.Department;
import MedCheck.models.Doctor;
import MedCheck.models.Hospital;
import MedCheck.models.Patient;
import MedCheck.models.enums.Gender;
import MedCheck.service.impl.DepartmentServiceImpl;
import MedCheck.service.impl.DoctorServiceImpl;
import MedCheck.service.impl.HospitalServiceImpl;
import MedCheck.service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MedCheck
//        1)  Оорукана тууралу бир программа жазыныз. Dao жана Service менен иштешкиле
//        (ар бир класстын dao жана service interface'тери жана ошол interface'ти implements
//        класстары болуш керек). Database деген класс ачып, ичинде бардык маалыматтарды
//        сактаган маалымат структурасы болсун(List<Hospital> hospitals).
//
//        2) Класстар:
//       * Hospital (Long id, String hospitalName, String address, List<Department> departments,
//       List<Doctor> doctors, List<Patient> patients),
//       * Department (Long id, String departmentName, List<Doctor> doctors),
//       * Doctor (Long id, String firstName, String lastName, Gender gender, int experienceYear),
//       * Patient (Long id, String firstName, String lastName, int age, Gender gender);3) Gender enum.
//
//        3)
//
//        HospitalService :
//
//        String addHospital(Hospital hospital);
//        Hospital findHospitalById(Long id);
//        List<Hospital> getAllHospital();
//        List<Patient> getAllPatientFromHospital(Long id);
//        String deleteHospitalById(Long id);
//        Map<String, Hospital> getAllHospitalByAddress(String address);
//
//        GenericService : (Department, Doctor , Patient)
//        String add(Long  hospitalId, T t);
//        void removeById(Long id);
//        String updateById(Long id, T t);
//
//        DepartmentService:
//        List<Department> getAllDepartmentByHospital(Long id);
//        Department findDepartmentByName(String name);
//
//        DoctorService:
//
//        Doctor findDoctorById(Long id);
//        // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
//        String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
//        List<Doctor> getAllDoctorsByHospitalId(Long id);
//        List<Doctor> getAllDoctorsByDepartmentId(Long id);

//        PatientService:
//        String addPatientsToHospital(Long id,List<Patient> patients);
//        Patient getPatientById(Long id);
//        Map<Integer, Patient> getPatientByAge();
//        List<Patient> sortPatientsByAge(String ascOrDesc);

        DataBase dataBase = new DataBase();
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(dataBase);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentDao);

        DoctorDaoImpl doctorDao = new DoctorDaoImpl(dataBase);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorDao);

        HospitalDaoImpl hospitalDao = new HospitalDaoImpl(dataBase);
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(hospitalDao);

        PatientDaoImpl patientDao = new PatientDaoImpl(dataBase);
        PatientServiceImpl patientService = new PatientServiceImpl(patientDao);


        // Ооруканалар
        Hospital hospital1 = new Hospital(1L, "Медсентр ", "Фрунзе 100");
        Hospital hospital2 = new Hospital(2L, "Vedanta", "Ленин 200");
        Hospital hospital3 = new Hospital(3L, "Национальный Госпиталь", "Токтогул 300");
        Hospital hospital4 = new Hospital(4L, "Менделеева", "Ала-Арча 400");
        Hospital hospital5 = new Hospital(5L, "Медсентр Ахунбаева", "Исанова 500");
        hospitalService.addHospital(hospital1);
        hospitalService.addHospital(hospital2);
        hospitalService.addHospital(hospital3);
        hospitalService.addHospital(hospital4);
        hospitalService.addHospital(hospital5);

        // Дарыгерлер

        Doctor doctor1 = new Doctor(1L, "Дмитрий", "Семенов", Gender.MALE, 10);
        Doctor doctor2 = new Doctor(2L, "Анастасия", "Петрова", Gender.FEMALE, 5);
        Doctor doctor3 = new Doctor(3L, "Иван", "Иванов", Gender.MALE, 15);
        Doctor doctor4 = new Doctor(4L, "Мария", "Сидорова", Gender.FEMALE, 7);
        Doctor doctor5 = new Doctor(5L, "Олег", "Николаев", Gender.MALE, 3);

        doctorService.add(1L, doctor1);
        doctorService.add(2L, doctor1);
        doctorService.add(3L, doctor2);
        doctorService.add(4L, doctor3);
        doctorService.add(5L, doctor4);
        doctorService.add(1L, doctor5);
        doctorService.add(2L, doctor4);
        doctorService.add(3L, doctor3);
        doctorService.add(4L, doctor2);
        doctorService.add(5L, doctor1);

        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        doctors.add(doctor5);
        // Бейтаптар
        Patient patient1 = new Patient(1L, "Алик", "Жунусов", 25, Gender.MALE);
        Patient patient2 = new Patient(2L, "Бактыгул", "Маматов", 30, Gender.FEMALE);
        Patient patient3 = new Patient(3L, "Ринат", "Токтосунов", 45, Gender.MALE);
        Patient patient4 = new Patient(4L, "Кулжигит", "Мамбеталиев", 50, Gender.MALE);
        Patient patient5 = new Patient(5L, "Айым", "Сатыбалдиева", 28, Gender.FEMALE);

        patientService.add(1L, patient1);
        patientService.add(1L, patient5);

        patientService.add(2L, patient2);
        patientService.add(2L, patient4);

        patientService.add(3L, patient2);
        patientService.add(3L, patient3);

        patientService.add(4L, patient4);
        patientService.add(4L, patient3);

        patientService.add(5L, patient1);
        patientService.add(5L, patient5);


        // Бөлүмдөр
        Department department1 = new Department(1L, "Терапия",doctors);
        Department department2 = new Department(2L, "Хирургия",doctors);
        Department department3 = new Department(3L, "Кардиология",doctors);
        Department department4 = new Department(4L, "Неврология",doctors);
        Department department5 = new Department(5L, "Педиатрия",doctors);
        Department department6 = new Department(6L, "Лор", doctors);

        departmentService.add(3L, department1);
        departmentService.add(2L, department2);
        departmentService.add(2L, department3);
        departmentService.add(2L, department4);
        departmentService.add(3L, department5);
        departmentService.add(3L, department2);
        departmentService.add(4L, department1);
        departmentService.add(4L, department2);
        departmentService.add(5L, department3);
        departmentService.add(5L, department4);
        departmentService.add(1L, department6);
        departmentService.add(5L, department6);
        departmentService.add(4L, department2);

//        System.out.println(departmentService.getAllDepartmentByHospital(3L));
//        System.out.println(hospitalService.getAllHospital());
//        System.out.println(hospitalService.getAllPatientFromHospital(1L));
//        System.out.println(hospitalService.deleteHospitalById(1L));
//        System.out.println(hospitalService.findHospitalById(1L));
//        System.out.println(hospitalService.getAllHospitalByAddress("Ленин 200"));

//        System.out.println(departmentService.getAllDepartmentByHospital(6L));
//        System.out.println(departmentService.findDepartmentByName("Педиатрия"));
//        System.out.println(departmentService.findDepartmentByName("Хирургия"));
//
//        doctorService.assignDoctorToDepartment(3L, Collections.singletonList(1L));  // не работает
//        System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
//        System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
//        System.out.println(doctorService.getAllDoctorsByDepartmentId(2L));

//        patientService.removeById(1L);
//        System.out.println(patientService.getPatientById(1L));
//        System.out.println(patientService.getPatientByAge());
//        System.out.println(patientService.sortPatientsByAge("asc"));
//        System.out.println(patientService.sortPatientsByAge("desc"));
//        System.out.println(patientService.updateById(1L, patient5));


    }

}
