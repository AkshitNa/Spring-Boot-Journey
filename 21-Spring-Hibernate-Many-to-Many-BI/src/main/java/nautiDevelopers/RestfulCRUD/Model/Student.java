package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 Primary Key
    private String name; //Column-02 Student name
    private int age;//Column-03 Student age

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    //In many-to-many mapping we create an additional table
    @JoinTable(
            name = "student_course", // Join table [Table 3]
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), //Column-01
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id") //Column-02
    )

    private Set<Course> courses; // Set of courses associated with the student
}

