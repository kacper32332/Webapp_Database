package bdbt_project.SpringApplication;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdresyDAO {
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        return null;
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
