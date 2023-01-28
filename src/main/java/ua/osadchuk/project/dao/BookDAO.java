package ua.osadchuk.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.osadchuk.project.models.Book;
import ua.osadchuk.project.models.Person;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(Integer book_id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE book_id=?", new Object[]{book_id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author_name, year_of_writing) VALUES (?, ?, ?)"
                , book.getName(), book.getAuthor_name(), book.getYear_of_writing());
    }

    public void update(Integer id, Book updateBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author_name=?, year_of_writing=? WHERE book_id=?"
                , updateBook.getName(), updateBook.getAuthor_name(), updateBook.getYear_of_writing(), id);
    }
}
