package pe.edu.upc.demoauthor.services;

import pe.edu.upc.demoauthor.entities.Author;
import pe.edu.upc.demoauthor.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface IBookService {
    public void insertar(Book book);

    List<Book> listar();
    List<Book> buscarFecha(LocalDate fecha);
    Long contarProyectosTipoA();

}
