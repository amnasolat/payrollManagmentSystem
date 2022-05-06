package payrollManagementSystem.example.payrollManagmentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Department;

public interface DepartmentRepo  extends JpaRepository<Department, String> {
}
