package payrollManagementSystem.example.payrollManagmentSystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue
    private String deptName;
    @OneToMany(mappedBy = "Department")
    private List<Employee> employee;
    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department() {
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
}


