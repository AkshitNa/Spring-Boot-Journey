package nautiDevelopers.RestfulCRUD.DTO;

import lombok.Data;

@Data
public class CollegeInfoDTO {

    private String collegeName;
    private int ratings;
    private int capacity; //to hold students

    // Write only those fields you want other to see.
    // This Class represents the data you want to transfer.
}
