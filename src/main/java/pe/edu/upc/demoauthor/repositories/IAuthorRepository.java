package pe.edu.upc.demoauthor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoauthor.entities.Author;
@Repository
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
}
