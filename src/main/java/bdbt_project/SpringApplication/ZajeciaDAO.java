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
public class ZajeciaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZajeciaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zajecia> list() {
        String sql = "SELECT * FROM zajecia";
        List<Zajecia> listZajecia = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Zajecia.class));
        return listZajecia;
    }

    public void save(Zajecia zajecia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("zajecia").usingColumns("nazwa_zajec", "limit_miejsc", "czas_trwania", "data_rozpoczecia", "data_zakonczenia", "nr_dyscypliny");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zajecia);
        insertActor.execute(param);
    }

    public Zajecia get(int nr_zajec) {
        Object[] args = {nr_zajec};
        String sql = "SELECT * FROM zajecia WHERE nr_zajec = " + args[0];
        Zajecia zajecia = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Zajecia.class));
        return zajecia;
    }

    public void update(Zajecia zajecia) {
        String sql = "UPDATE zajecia SET nazwa_zajec=:nazwa_zajec, limit_miejsc=:limit_miejsc, czas_trwania=:czas_trwania, data_rozpoczecia=:data_rozpoczecia, data_zakonczenia=:data_zakonczenia, nr_dyscypliny=:nr_dyscypliny WHERE nr_zajec=:nr_zajec";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zajecia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int nr_zajec) {
        String sql = "DELETE FROM zajecia WHERE nr_zajec = ?";
        jdbcTemplate.update(sql, nr_zajec);
    }
}
