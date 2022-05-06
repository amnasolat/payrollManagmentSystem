package payrollManagementSystem.example.payrollManagmentSystem.dto;


import lombok.Data;

import java.util.Date;

@Data
public class SalariesDTO {
    private int id;
    private String empName;
    private Date createdDate;
}
