package nautiDevelopers.RestfulCRUD.Entity;
import jakarta.persistence.*;

@Entity //Mark the Class as Entity
@Table(name = "college")
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

    //Constructors
    public College() {
    }

    public College(String collegeName, String location, String email) {
        this.collegeName = collegeName;
        this.location = location;
        this.email = email;
    }

    //Getter And Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString()
    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

