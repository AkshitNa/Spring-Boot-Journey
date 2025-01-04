package nautiDevelopers.RestfulCRUD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Column-01 Primary Key

    private String name;//Column-02

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false) //Column-03 Foreign Key in Employee table
    @JsonIgnore // Prevents recursion
    private Company company; // Reference to Company
}

