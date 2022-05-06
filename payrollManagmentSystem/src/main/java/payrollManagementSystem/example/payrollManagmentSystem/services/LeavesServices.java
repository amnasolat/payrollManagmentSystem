package payrollManagementSystem.example.payrollManagmentSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollManagementSystem.example.payrollManagmentSystem.domain.Leaves;
import payrollManagementSystem.example.payrollManagmentSystem.dto.LeavesDTO;
import payrollManagementSystem.example.payrollManagmentSystem.repo.LeavesRepo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LeavesServices {

    @Autowired
    private LeavesRepo leaveRepo;

    public List<LeavesDTO> getAllLeave(int id){
        return leaveRepo.findAll()
                .stream()
                .map(leave -> convertEntitytoDTO(leave, id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    private LeavesDTO convertEntitytoDTO(Leaves leave, int id){
        if(id == leave.getEmployee().getId()) {
            LeavesDTO leavesDTO = new LeavesDTO();
            leavesDTO.setNoOfLeaves(leave.getNoOfLeaves());
            leavesDTO.setId(leave.getEmployee().getId());
            leavesDTO.setEmpName(leave.getEmployee().getEmpName());
            return leavesDTO;
        }
        return null;
    }
}
