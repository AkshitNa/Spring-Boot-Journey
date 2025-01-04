package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 Primary Key

    private String name; //Column-02

    @ManyToOne
    @JoinColumn(name = "team_id") //  //Column-03 -> Foreign Key in Member table
    private Team team; // Reference to Team
}

