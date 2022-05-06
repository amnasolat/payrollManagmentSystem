package payrollManagementSystem.example.payrollManagmentSystem.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Salaries;
import payrollManagementSystem.example.payrollManagmentSystem.dto.SalariesDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.SalariesRepo;
import payrollManagementSystem.example.payrollManagmentSystem.services.SalariesServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SalaryResponse {
    @Autowired
    private SalariesRepo salariesRepo;

    @Autowired
    private SalariesServices salariesServices;

    @GetMapping("/salary")
    public List<Salaries> retrieveAllUsers(){
        return salariesRepo.findAll();
    }

    @GetMapping("/salary/{id}")
    public Optional<Salaries> retrieveUser(@PathVariable int id){
        Optional<Salaries> user = salariesRepo.findById(id);


        return user;
    }

    @GetMapping("/salary/employee")
    public List<SalariesDTO> retrieveAllSalary(int id){
        List<SalariesDTO> salariesDTOS = salariesServices.getAllSalary(id);

        return salariesDTOS;
    }

    @PostMapping("/salary")
    public ResponseEntity<Object> createUser(@Validated @RequestBody Salaries salary){
        Salaries savedUser = salariesRepo.save(salary);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/salary/{id}")
    public void deleteUser(@PathVariable int id){
        salariesRepo.deleteById(id);

    }

}
