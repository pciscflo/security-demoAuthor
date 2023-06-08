package pe.edu.upc.demoauthor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoauthor.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

    @Query("from Book v where v.publicationDateBook =:fecha")
    List<Book> findBypublicationDateBook(@Param("fecha") LocalDate fecha);
    @Query("SELECT COUNT(p) FROM Book p")
    Long cantidad();
}
