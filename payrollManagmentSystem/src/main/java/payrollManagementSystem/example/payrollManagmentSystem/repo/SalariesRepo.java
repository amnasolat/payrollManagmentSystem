package payrollManagementSystem.example.payrollManagmentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Salaries;

public interface SalariesRepo extends JpaRepository<Salaries,Integer> {
}
