package payrollManagementSystem.example.payrollManagmentSystem.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Salaries;
import payrollManagementSystem.example.payrollManagmentSystem.dto.SalariesDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.SalariesRepo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SalariesServices {

    @Autowired
    private SalariesRepo salariesRepo;

    public List<SalariesDTO> getAllSalary(int id){
        return SalariesRepo.findAll()
                .stream()
                .map(salary -> convertEntityToDTO(salary, id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    private SalariesDTO convertEntityToDTO(Salaries salary, int id){
        if(id == salary.getEmployee().getId()) {
            SalariesDTO salaryDTO = new SalariesDTO();
            salaryDTO.setId(salary.getEmployee().getId());
            salaryDTO.setEmpName(salary.getEmployee().getEmpName());
            salaryDTO.setCreatedDate(salary.getCreatedDate());
            return salaryDTO;
        }
        return null;
    }

}