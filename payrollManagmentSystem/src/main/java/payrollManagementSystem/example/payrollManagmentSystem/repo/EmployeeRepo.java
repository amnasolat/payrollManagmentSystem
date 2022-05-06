package payrollManagementSystem.example.payrollManagmentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
