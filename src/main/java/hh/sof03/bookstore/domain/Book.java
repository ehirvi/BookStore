package hh.sof03.bookstore.domain;

public class Book {

    private String title;
    private String author;
    private int year;
    private String isbn;
    private float price;


    public Book() {}

    public Book(String title, String author, int year, String isbn, float price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
