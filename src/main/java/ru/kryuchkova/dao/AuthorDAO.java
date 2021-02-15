package ru.kryuchkova.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kryuchkova.model.Author;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDAO implements DAO<Author> {

    private static final Logger log = LoggerFactory.getLogger(AuthorDAO.class);
    private JdbcTemplate jdbcTemplate;

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Author> rowMapper = (rs, rowNum) -> {
        Author author = new Author();
        author.setAuthor_id(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setCountry(rs.getString("country"));
        return author;
    };


    @Override
    public List<Author> list() {
        String sql = "SELECT author_id, first_name, last_name, country from TBL_AUTHORS";
        return jdbcTemplate.query(sql, rowMapper);
    }


    @Override
    public void create(Author author) {
        String sql = "insert into TBL_AUTHORS(first_name,last_name,country) values(?,?,?)";
        int insert = jdbcTemplate.update(sql, author.getFirstName(), author.getLastName(), author.getCountry());
        if (insert == 1) {
            log.info("New author added: " + author.getFirstName() + " " + author.getLastName());
        }
    }



    @Override
    public Optional<Author> get(int id) {
        String sql = "SELECT author_id,first_name,last_name,country from TBL_AUTHORS where author_id = ?";
        Author author = null;
        try {
            author = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException ex) {
            log.info("Author not found: " + id);
        }
        return Optional.ofNullable(author);
    }



    @Override
    public void update(Author author, int id) {
        String sql = "update TBL_AUTHORS set first_name = ?, last_name = ?, country = ? where author_id = ?";
        int update = jdbcTemplate.update(sql,author.getFirstName(),author.getLastName(),author.getCountry(),id);
        if(update == 1) {
            log.info("Author Updated: " + author.getFirstName() + " " + author.getLastName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from TBL_AUTHORS where author_id = ?";
        int delete = jdbcTemplate.update(sql,id);
        if(delete == 1) {
            log.info("Author Deleted: " + id);
        }
    }
}
