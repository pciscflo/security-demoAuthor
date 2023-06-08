package pe.edu.upc.demoauthor.dtos;

import pe.edu.upc.demoauthor.entities.Author;

import java.time.LocalDate;

public class BookDTO {
    private int idBook;
    private String nameBook;
    private LocalDate publicationDateBook;
    private int nhojasBook;
    private Author author;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDate getPublicationDateBook() {
        return publicationDateBook;
    }

    public void setPublicationDateBook(LocalDate publicationDateBook) {
        this.publicationDateBook = publicationDateBook;
    }

    public int getNhojasBook() {
        return nhojasBook;
    }

    public void setNhojasBook(int nhojasBook) {
        this.nhojasBook = nhojasBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
