package payrollManagementSystem.example.payrollManagmentSystem.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Employee;
import payrollManagementSystem.example.payrollManagmentSystem.dto.EmployeeDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.EmployeeRepo;
import payrollManagementSystem.example.payrollManagmentSystem.services.EmployeeServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeResponse {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeServices employeeService;



    @GetMapping("/employee")
    public List<Employee> retrieveAllUsers(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> retrieveUser(@PathVariable int id){
        Optional<Employee> user = employeeRepo.findById(id);



        return user;
    }
    @GetMapping("/employee/department")
    public List<EmployeeDTO> retrieveAllEmployee(@RequestParam String deptName){
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployeeDepartment(deptName);

        return employeeDTOS;
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createUser(@Validated @RequestBody Employee employee){
        Employee savedUser = employeeRepo.save(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/employee/{id}")
    public void deleteUser(@PathVariable int id){
        employeeRepo.deleteById(id);


    }

}
