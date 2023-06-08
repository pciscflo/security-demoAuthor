package pe.edu.upc.demoauthor.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;
    @Column(name = "nameAuthor",length = 45,nullable = false)
    private String nameAuthor;
    @Column(name = "emailAuthor",length = 45,nullable = false)
    private  String emailAuthor;
    @Column(name = "manufacturingDateVehiculo")
    private LocalDate birthDateAuthor;

    public Author() {
    }

    public Author(int idAuthor, String nameAuthor, String emailAuthor, LocalDate birthDateAuthor) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
        this.emailAuthor = emailAuthor;
        this.birthDateAuthor = birthDateAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }

    public LocalDate getBirthDateAuthor() {
        return birthDateAuthor;
    }

    public void setBirthDateAuthor(LocalDate birthDateAuthor) {
        this.birthDateAuthor = birthDateAuthor;
    }
}
