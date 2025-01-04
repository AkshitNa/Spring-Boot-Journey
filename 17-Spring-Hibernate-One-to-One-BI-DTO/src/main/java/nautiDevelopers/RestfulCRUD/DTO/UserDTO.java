package nautiDevelopers.RestfulCRUD.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private ProfileDTO profile;
}
