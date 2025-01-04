package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Column-01
    private String name;//Column-02

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id") //Column-03 -> Foreign key in User table referring to Profile ID.
    private Profile profile;
}

