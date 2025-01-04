package nautiDevelopers.RestfulCRUD.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity //Mark the Class as Entity
@Table(name = "college")
@Data
public class College {

    @Id //To mark the column as Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "collegeName")
    private String collegeName;
    @Column(name = "location")
    private String location;
    @Column(name = "email")
    private String email;
}

    //Constructors -> Lombok
    //Getter And Setters -> Lombok
    //toString() -> Lombok


