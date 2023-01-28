package ua.osadchuk.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.osadchuk.project.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(Integer person_id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{person_id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(full_name, birthday) VALUES (?,?)"
                , person.getFull_name(), person.getBirthday());
    }

    public void update(Integer id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?, birthday=? WHERE person_id=?"
                , updatePerson.getFull_name(), updatePerson.getBirthday(), id);
    }
}
