import student.enterpriseJava.entity.Employee;
import student.enterpriseJava.persistence.EmployeeDao;

import java.util.List;

/**
 * Created by Student on 10/22/2015.
 */
public class EmployeeDriver {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee = new Employee(0, "Marcie", "Madeline", "912-55-6134", "IT", "201", "987-6541");

        int newEmployeeId = dao.createEmployee(employee);
        Employee newEmployee = dao.getEmployeeById(newEmployeeId);
        System.out.println(newEmployee.toString());

        Employee update = new Employee(newEmployeeId, "Martin", "Martinique", "912-55-6134", "IT", "202", "321-6548");
        dao.updateEmployee(update);
        Employee updatedEmployee = dao.getEmployeeById(newEmployeeId);
        System.out.println(updatedEmployee.toString());

        dao.deleteEmployee(newEmployeeId);
        List<Employee> allEmps = dao.getAllEmployees();

        for (Employee emp : allEmps) {
            System.out.println(emp.toString());
        }
    }
}
