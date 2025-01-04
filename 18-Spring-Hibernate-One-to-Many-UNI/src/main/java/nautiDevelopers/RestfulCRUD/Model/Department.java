package nautiDevelopers.RestfulCRUD.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Column-01 -> department_id

    private String departmentName;//Column-02

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id") //Column-03 -> Foreign key in Employee table
    private List<Employee> employees;
}
