package payrollManagementSystem.example.payrollManagmentSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Employee;
import payrollManagementSystem.example.payrollManagmentSystem.dto.EmployeeDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.EmployeeRepo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeDTO> getAllEmployeeDepartment(String deptName){
        return employeeRepo.findAll()
                .stream()
                .map(employee -> convertEntityToDTO(employee,deptName))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertEntityToDTO(Employee employee, String deptName){
        if(deptName.equals(employee.getDepartment().getDeptName())) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmpName(employee.getEmpName());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setDeptName(employee.getDepartment().getDeptName());
            return employeeDTO;
        }
        return null;
    }

}
