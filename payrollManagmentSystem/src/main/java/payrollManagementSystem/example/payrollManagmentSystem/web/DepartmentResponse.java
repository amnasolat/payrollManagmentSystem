package payrollManagementSystem.example.payrollManagmentSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Department;
import payrollManagementSystem.example.payrollManagmentSystem.repo.DepartmentRepo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResponse {
    @Autowired
    private DepartmentRepo departmentRepo;
    @GetMapping("/dept")
    public List<Department> retrieveAllDept(){
        return departmentRepo.findAll();
    }
    @GetMapping("/department")
    public Optional<Department> retrieveUser(@RequestParam String id) {
        Optional<Department> user = departmentRepo.findById(id);
        return user;
    }
    @PostMapping("/department")
    public ResponseEntity<Object> createUser(@RequestBody Department department){
        Department savedUser = departmentRepo.save(department);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{deptName}")
                .buildAndExpand(savedUser.getDeptName())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/dept/{dept}")
    public void deleteUser(@RequestParam String dept){
        departmentRepo.deleteById(dept);



}
}
