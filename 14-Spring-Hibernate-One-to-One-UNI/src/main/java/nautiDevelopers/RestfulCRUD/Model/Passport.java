package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "passport_id")
    private Long id;//Column-01 [Primary key]
    private String passportNumber;//Column-02
}




