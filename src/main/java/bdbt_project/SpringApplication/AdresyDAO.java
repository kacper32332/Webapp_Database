package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        String sql = "SELECT * FROM adresy";

        List<Adresy> listAdresy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    public void save(Adresy adresy){

    }

    public Adresy get(int nr_adresu){
        return null;
    }

    public void update(Adresy adresy){

    }

    public void delete(int nr_adresu){

    }
}
