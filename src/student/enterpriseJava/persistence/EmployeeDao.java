package student.enterpriseJava.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import student.enterpriseJava.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 10/22/2015.
 */
public class EmployeeDao {

    public Integer createEmployee(Employee employee) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            employeeId = (Integer)session.save(employee);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx!= null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return employeeId;
    }

    public List<Employee> getAllEmployees() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<Employee> employees = new ArrayList<Employee>();

        try {
            tx = session.beginTransaction();
            employees = session.createQuery("from employee_data").list();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return employees;
    }

    public Employee getEmployeeById(int emp_id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Employee employee = null;

        try {
            tx = session.beginTransaction();
            String sql = "from employee_data where emp_id = :id";
            Query query = session.createQuery(sql);
            query.setInteger("id", emp_id);
            employee = (Employee)query.uniqueResult();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }

        return employee;
    }

    public void updateEmployee(Employee employee) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (HibernateException hex) {
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(int emp_id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.load(Employee.class, new Integer(emp_id));
            session.delete(employee);
            tx.commit();
        } catch (HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
