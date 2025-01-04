package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 Primary Key

    private String name; // //Column-02

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true) // Inverse relationship
    @JsonIgnore // Prevent infinite recursion
    private List<Member> members; // List of members
}

