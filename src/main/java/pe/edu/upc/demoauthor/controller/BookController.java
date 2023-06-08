package pe.edu.upc.demoauthor.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoauthor.dtos.AuthorDTO;
import pe.edu.upc.demoauthor.dtos.BookDTO;
import pe.edu.upc.demoauthor.entities.Author;
import pe.edu.upc.demoauthor.entities.Book;
import pe.edu.upc.demoauthor.services.IAuthorService;
import pe.edu.upc.demoauthor.services.IBookService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bS;

    @PostMapping
    public void registrar(@RequestBody BookDTO dto) {
        ModelMapper m = new ModelMapper();
        Book a = m.map(dto, Book.class);
        bS.insertar(a);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<BookDTO> listar() {
        return bS.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,BookDTO.class);

        }).collect(Collectors.toList());
    }


    @PostMapping("/buscar")
    public List<BookDTO> buscar(@RequestBody LocalDate fecha) {
        return bS.buscarFecha(fecha).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BookDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/contars")
    public Long contarProyectosTipoA() {
        return bS.contarProyectosTipoA();
    }
}
