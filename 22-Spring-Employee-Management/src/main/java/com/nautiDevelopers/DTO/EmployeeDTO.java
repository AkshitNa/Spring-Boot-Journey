package com.nautiDevelopers.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    // Write only those fields you want other to see.
    // This Class represents the data you want to transfer.
}
