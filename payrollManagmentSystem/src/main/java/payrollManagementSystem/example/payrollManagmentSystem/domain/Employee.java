package payrollManagementSystem.example.payrollManagmentSystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private long Id;
    private String empName;
    private Date joinDate;
    private double salary;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    public Employee(long Id, String empName, Date joinDate, double salary) {
        this.Id = Id;
        this.empName = empName;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public Employee() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", empName='" + empName + '\'' +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
