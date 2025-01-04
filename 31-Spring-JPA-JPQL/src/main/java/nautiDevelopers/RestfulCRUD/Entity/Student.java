package nautiDevelopers.RestfulCRUD.Entity;
import jakarta.persistence.*;
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

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    //Constructors
    //Getter And Setters
    //toString()
}

