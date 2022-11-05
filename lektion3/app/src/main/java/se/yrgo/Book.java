package se.yrgo;

import java.util.Date;

public class Book {
    private int id;
    private Date purchaseDate;
    private BookEdition edition;
    
    public Book(int id, String title, String author, String isbn) {
        this.id = id;
        this.purchaseDate = new Date();
        this.edition = new BookEdition(title, author, isbn);
    }

    public Book(int id, Date purchaseDate, BookEdition edition) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.edition = edition;
    }

    public static Book newBook(int id, String title, String author, String isbn) {
        Date date = new Date();
        BookEdition be = new BookEdition(title, author, isbn);
        return new Book(id, date, be);
    }
}
