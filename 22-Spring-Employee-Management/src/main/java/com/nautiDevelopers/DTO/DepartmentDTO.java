package com.nautiDevelopers.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentDescription;

    // Write only those fields you want other to see.
    // This Class represents the data you want to transfer.
}
