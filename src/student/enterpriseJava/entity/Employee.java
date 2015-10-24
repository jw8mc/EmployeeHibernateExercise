package student.enterpriseJava.entity;

/**
 * Represents an Employee. Used for the DAO exercise.
 *
 * @author YOUR NAME HERE
 * @version 1.0 10/20/15.
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String room;
    private String phone;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String socialSecurityNumber, String department, String room, String phone) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.department = department;
        this.room = room;
        this.phone = phone;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return  System.lineSeparator() +
                "Employee: " + " "
                + employeeId + " "
                + firstName + " "
                + lastName + " "
                + socialSecurityNumber + " "
                + room + " "
                + department + " "
                + phone;
    }
}
