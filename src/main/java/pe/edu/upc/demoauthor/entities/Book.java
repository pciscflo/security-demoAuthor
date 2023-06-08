package pe.edu.upc.demoauthor.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idBook;
    @Column(name = "nameBook",length = 40,nullable = false)
    private String nameBook;
    @Column(name = "publicationDateBook", nullable = false)
    private LocalDate publicationDateBook;
    @Column(name ="nhojasBook", nullable = false )
    private int nhojasBook;
    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private Author author;

    public Book() {
    }

    public Book(int idBook, String nameBook, LocalDate publicationDateBook, int nhojasBook, Author author) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.publicationDateBook = publicationDateBook;
        this.nhojasBook = nhojasBook;
        this.author = author;
    }

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
