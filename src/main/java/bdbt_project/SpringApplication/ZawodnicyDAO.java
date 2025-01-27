package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZawodnicyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZawodnicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zawodnicy> list() {
        String sql = "SELECT * FROM zawodnicy";
        List<Zawodnicy> listZawodnicy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Zawodnicy.class));
        return listZawodnicy;
    }

    public void save(Zawodnicy zawodnicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("zawodnicy").usingColumns("imie", "nazwisko", "plec", "email", "nr_telefonu", "data_urodzenia", "nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawodnicy);
        insertActor.execute(param);
    }

    public Zawodnicy get(int nr_zawodnika) {
        Object[] args = {nr_zawodnika};
        String sql = "SELECT * FROM zawodnicy WHERE nr_zawodnika = " + args[0];
        Zawodnicy zawodnik = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Zawodnicy.class));
        return zawodnik;
    }

    public void update(Zawodnicy zawodnicy) {
        String sql = "UPDATE zawodnicy SET imie=:imie, nazwisko=:nazwisko, plec=:plec, email=:email, nr_telefonu=:nr_telefonu, data_urodzenia=:data_urodzenia, nr_adresu=:nr_adresu WHERE nr_zawodnika=:nr_zawodnika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawodnicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int nr_zawodnika) {
        String sql = "DELETE FROM zawodnicy WHERE nr_zawodnika = ?";
        jdbcTemplate.update(sql, nr_zawodnika);
    }
}
