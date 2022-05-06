package payrollManagementSystem.example.payrollManagmentSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payrollManagementSystem.example.payrollManagmentSystem.domain.MedicalAllowance;
import payrollManagementSystem.example.payrollManagmentSystem.repo.MedicalAllowanceRepo;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicalAllowanceResponse {
    @Autowired
    private MedicalAllowanceRepo medicalAllowanceRepo;

    @GetMapping("/medicalallowance")
    public List<MedicalAllowanceRepo> retrieveAllUsers(){
        return medicalAllowanceRepo.findAll();
    }

    @GetMapping("/medicalallowance/{id}")
    public Optional<MedicalAllowanceRepo> retrieveUser(@PathVariable int id){
        Optional<MedicalAllowanceRepo> user = medicalAllowanceRepo.findById(id);


        return user;
    }

    @PostMapping("/medicalallowance")
    public ResponseEntity<Object> createUser(@RequestBody MedicalAllowance medicalAllowance){
        MedicalAllowance savedUser = medicalAllowanceRepo.save(medicalAllowance);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/medicalallowance/{id}")
    public void deleteUser(@PathVariable int id){
        medicalAllowanceRepo.deleteById(id);


    }

}
