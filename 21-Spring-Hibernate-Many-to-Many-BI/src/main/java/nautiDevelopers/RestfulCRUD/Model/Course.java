package nautiDevelopers.RestfulCRUD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 Primary Key
    private String title;//Column-02 Course title
    private double fees;//Column-03 Course fees

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY) // Inverse side of the relationship
    @JsonIgnore // Prevents infinite recursion
    private Set<Student> students;
}

