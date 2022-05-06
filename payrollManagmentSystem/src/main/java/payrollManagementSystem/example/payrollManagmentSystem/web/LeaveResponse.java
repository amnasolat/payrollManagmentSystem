package payrollManagementSystem.example.payrollManagmentSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Leaves;
import payrollManagementSystem.example.payrollManagmentSystem.dto.LeavesDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.LeavesRepo;
import payrollManagementSystem.example.payrollManagmentSystem.services.LeavesServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LeaveResponse {
    @Autowired
    private LeavesRepo leaveRepo;

    @Autowired
    private LeavesServices leaveService;

    @GetMapping("/leave")
    public List<Leaves> retrieveAllUsers(){
        return leaveRepo.findAll();
    }

    @GetMapping("/leave/{id}")
    public Optional<Leaves> retrieveUser(@PathVariable int id){
        Optional<Leaves> user = leaveRepo.findById(id);


        return user;
    }
    @GetMapping("/employee-leave")
    public List<LeavesDTO> retrieveAllLeave(@RequestParam int id){
        List<LeavesDTO> leaveDTOS = leaveService.getAllLeave(id);
        return leaveDTOS;
    }

    @PostMapping("/leave")
    public ResponseEntity<Object> createUser(@RequestBody Leaves leave){
        Leaves savedUser = leaveRepo.save(leave);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/leave/{id}")
    public void deleteUser(@PathVariable int id){
        leaveRepo.deleteById(id);

    }

}
