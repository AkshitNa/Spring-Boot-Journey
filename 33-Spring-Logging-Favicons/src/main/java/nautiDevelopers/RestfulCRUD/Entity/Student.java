package nautiDevelopers.RestfulCRUD.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //Mark the Class as Entity
@Table(name = "college")
public class Student {

    @Id //To mark the column as Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @NotEmpty
    @Column(name = "age")
    private int age;
    @NotEmpty
    @Column(name = "email")
    private String email;

    //Constructors
    //Getter And Setters
    //toString()
}

