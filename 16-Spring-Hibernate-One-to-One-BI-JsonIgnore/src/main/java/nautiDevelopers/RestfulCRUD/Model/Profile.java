package nautiDevelopers.RestfulCRUD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01
    private String bio; //Column-02
    @OneToOne(mappedBy = "profile") // Inverse relationship
    @JsonIgnore // Prevents recursion // Exclude from JSON response
    private User user;
}
