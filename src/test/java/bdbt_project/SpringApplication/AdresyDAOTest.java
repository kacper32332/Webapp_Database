package bdbt_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class AdresyDAOTest {
    private AdresyDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        datasource.setUsername("BOGDANSKI");
        datasource.setPassword("BOGDANSKI");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList() {
        List<Adresy> listAdresy = dao.list();
        assertTrue(listAdresy.isEmpty());
    }

    @Test
    void testSave() {
        Adresy adresy = new Adresy(50, "Warszawa", "Marszałkowska", "00-000", "1", "1");
        dao.save(adresy);
    }

    @Test
    void testGet() {
        fail("Not yet implemented");
    }

    @Test
    void testUpdate() {
        fail("Not yet implemented");
    }

    @Test
    void testDelete() {
        fail("Not yet implemented");
    }
}
