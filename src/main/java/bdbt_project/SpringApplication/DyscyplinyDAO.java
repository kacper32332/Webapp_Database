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
public class DyscyplinyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DyscyplinyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dyscypliny> list(){
        String sql = "SELECT * FROM dyscypliny";

        List<Dyscypliny> listDyscypliny = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Dyscypliny.class));
        return listDyscypliny;
    }

    public void save(Dyscypliny dyscypliny){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("dyscypliny").usingColumns("nazwa_dyscypliny", "opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dyscypliny);
        insertActor.execute(param);
    }

    public Dyscypliny get(int nr_dyscypliny){
        Object[] args = {nr_dyscypliny};
        String sql = "SELECT * FROM dyscypliny WHERE nr_dyscypliny = " + args[0];
        Dyscypliny dyscyplina = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Dyscypliny.class));
        return dyscyplina;
    }

    public void update(Dyscypliny dyscypliny){
        String sql = "UPDATE dyscypliny SET nazwa_dyscypliny=:nazwa_dyscypliny, opis=:opis WHERE nr_dyscypliny=:nr_dyscypliny";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dyscypliny);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int nr_dyscypliny){
        String sql = "DELETE FROM dyscypliny WHERE nr_dyscypliny = ?";
        jdbcTemplate.update(sql, nr_dyscypliny);
    }
}
