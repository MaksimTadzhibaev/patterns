package ru.tadzh.entity;

import javax.persistence.*;

/*
Описание сущности "Книга"
 */

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publicationDate", nullable = false)
    private Integer publicationDate;

    @Column(name = "isbn", nullable = false)
    private Long isbn;

    public Book() {
    }

    public Book(Long id, String title, Integer publicationDate, Long isbn) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
