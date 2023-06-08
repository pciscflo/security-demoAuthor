package pe.edu.upc.demoauthor.dtos;

import java.time.LocalDate;

public class AuthorDTO {

    private int idAuthor;
    private String nameAuthor;
    private  String emailAuthor;
    private LocalDate birthDateAuthor;

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
