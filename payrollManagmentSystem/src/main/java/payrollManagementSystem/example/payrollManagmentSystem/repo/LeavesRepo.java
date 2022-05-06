package payrollManagementSystem.example.payrollManagmentSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Leaves;

public interface LeavesRepo extends JpaRepository<Leaves, Integer> {

}
