package pe.edu.upc.demoauthor.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoauthor.dtos.AuthorDTO;
import pe.edu.upc.demoauthor.entities.Author;
import pe.edu.upc.demoauthor.services.IAuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AuthorController {
    @Autowired
    private IAuthorService aS;

    @PostMapping
    public void registrar(@RequestBody AuthorDTO dto) {
        ModelMapper m = new ModelMapper();
        Author a = m.map(dto, Author.class);
        aS.insertar(a);
    }

    @PutMapping
    public void modificar(@RequestBody AuthorDTO dto) {
        ModelMapper m = new ModelMapper();
        Author a = m.map(dto, Author.class);
        aS.insertar(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.eliminar(id);
    }

    @GetMapping("/{id}")
    public AuthorDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        AuthorDTO dto=m.map(aS.listarId(id),AuthorDTO.class);
        return dto;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AuthorDTO> listar() {
        return aS.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AuthorDTO.class);

        }).collect(Collectors.toList());
    }
}
