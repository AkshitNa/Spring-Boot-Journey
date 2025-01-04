package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 [Primary Key]
    private String name;//Column-02

    @OneToOne(cascade = CascadeType.ALL)//It ensures that operations on Person (e.g., save/delete) cascade to Passport.
    @JoinColumn(name = "passport_id") //Column-03 -> Foreign key in Person table referring to the Primary key of Passport Table.
    private Passport passport;
}

/*
Note: If I delete any row in "Person Table", it is allowed but not in "Passport Table" if there exists an ID
      in "Person Table"
 */



