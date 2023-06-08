package pe.edu.upc.demoauthor.services;

import pe.edu.upc.demoauthor.entities.Author;

import java.util.List;

public interface IAuthorService {
    public void insertar(Author author);

    public void eliminar(int idAuthor);

    public Author listarId(int idAuthor);

    List<Author> listar();

}
