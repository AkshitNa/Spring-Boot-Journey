package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

