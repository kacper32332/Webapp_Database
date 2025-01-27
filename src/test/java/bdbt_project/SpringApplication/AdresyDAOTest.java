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
        int id = 2;
        Adresy adresy = dao.get(id);
        System.out.println(adresy.toString());
    }

    @Test
    void testUpdate() {
        Adresy adresy = new Adresy();
        adresy.setNr_adresu(1);
        adresy.setMiejscowosc("Warszawa111");
        adresy.setUlica("Marszałkowska111");
        adresy.setKod_pocztowy("11-000");
        adresy.setNr_domu("12");
        adresy.setNr_mieszkania("12");
        dao.update(adresy);
    }

    @Test
    void testDelete() {
        int id = 62;
        dao.delete(id);
    }
}
