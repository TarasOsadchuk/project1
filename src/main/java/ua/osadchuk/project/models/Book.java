package ua.osadchuk.project.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Book title must not be empty")
    @Size(min = 2, max = 100, message = "Book title must be between 2 and 100 characters long")
    private String title;

    @NotEmpty(message = "Author must not be empty")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters long")
    private String author;

    @Min(value = 1500, message = "Year must be greater than 1500")
    @Max(value = 2023, message = "The year must be less than 2023")
    private int year;

    public Book() {

    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}