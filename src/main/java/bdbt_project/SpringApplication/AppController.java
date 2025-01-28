package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/adresy").setViewName("adresy");
        registry.addViewController("/dyscypliny").setViewName("dyscypliny");
        registry.addViewController("/zawodnicy").setViewName("zawodnicy");
        registry.addViewController("/zajecia").setViewName("zajecia");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Autowired
    private AdresyDAO AdresDAO;

//    Adresy -----------------------------------------------------

    @RequestMapping("/adresy")
    public String viewAdresy(Model model) {
        List<Adresy> listAdresy = AdresDAO.list();
        model.addAttribute("listAdresy", listAdresy);
        return "adresy";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("adresy") Adresy adresy) {
        AdresDAO.save(adresy);
        return "redirect:/adresy";
    }

    @RequestMapping(value = "/editAdres", method = RequestMethod.POST)
    public String editAdres(@ModelAttribute("adresy") Adresy adresy) {
        Adresy istniejacyAdres = AdresDAO.get(adresy.getNr_adresu());
        istniejacyAdres.setNr_adresu(adresy.getNr_adresu());
        istniejacyAdres.setMiejscowosc(adresy.getMiejscowosc());
        istniejacyAdres.setUlica(adresy.getUlica());
        istniejacyAdres.setKod_pocztowy(adresy.getKod_pocztowy());
        istniejacyAdres.setNr_domu(adresy.getNr_domu());
        istniejacyAdres.setNr_mieszkania(adresy.getNr_mieszkania());
        AdresDAO.update(istniejacyAdres);
        return "redirect:/adresy";
    }

    @RequestMapping("/deleteA/{nr_adresu}")
    public String delete(@PathVariable(name = "nr_adresu") int nr_adresu) {
        AdresDAO.delete(nr_adresu);
        return "redirect:/adresy";
    }

    //    Dyscypliny -----------------------------------------------------
    @Autowired
    private DyscyplinyDAO DyscyplinaDAO;

    @RequestMapping("/dyscypliny")
    public String viewDyscypliny(Model model) {
        List<Dyscypliny> listDyscypliny = DyscyplinaDAO.list();
        model.addAttribute("listDyscypliny", listDyscypliny);
        return "dyscypliny";
    }

    @RequestMapping(value = "/saveDyscyplina", method = RequestMethod.POST)
    public String save(@ModelAttribute("dyscypliny") Dyscypliny dyscypliny) {
        DyscyplinaDAO.save(dyscypliny);
        return "redirect:/dyscypliny";
    }

    @RequestMapping(value = "/editDyscyplina", method = RequestMethod.POST)
    public String editDyscyplina(@ModelAttribute("dyscypliny") Dyscypliny dyscypliny) {
        Dyscypliny istniejacaDyscyplina = DyscyplinaDAO.get(dyscypliny.getNr_dyscypliny());
        istniejacaDyscyplina.setNr_dyscypliny(dyscypliny.getNr_dyscypliny());
        istniejacaDyscyplina.setNazwa_dyscypliny(dyscypliny.getNazwa_dyscypliny());
        istniejacaDyscyplina.setOpis(dyscypliny.getOpis());
        DyscyplinaDAO.update(istniejacaDyscyplina);
        return "redirect:/dyscypliny";
    }

    @RequestMapping("/deleteD/{nr_dyscypliny}")
    public String deleteD(@PathVariable(name = "nr_dyscypliny") int nr_dyscypliny) {
        DyscyplinaDAO.delete(nr_dyscypliny);
        return "redirect:/dyscypliny";
    }

    //    Zawodnicy -----------------------------------------------------
    @Autowired
    private ZawodnicyDAO ZawodnikDAO;

    @RequestMapping("/zawodnicy")
    public String viewZawodnicy(Model model) {
        List<Zawodnicy> listZawodnicy = ZawodnikDAO.list();
        model.addAttribute("listZawodnicy", listZawodnicy);
        return "zawodnicy";
    }

    @RequestMapping(value = "/saveZawodnik", method = RequestMethod.POST)
    public String save(@ModelAttribute("zawodnicy") Zawodnicy zawodnicy) {
        ZawodnikDAO.save(zawodnicy);
        return "redirect:/zawodnicy";
    }

    @RequestMapping(value = "/editZawodnik", method = RequestMethod.POST)
    public String editZawodnik(@ModelAttribute("zawodnicy") Zawodnicy zawodnicy) {
        Zawodnicy istniejacyZawodnik = ZawodnikDAO.get(zawodnicy.getNr_zawodnika());
        istniejacyZawodnik.setNr_zawodnika(zawodnicy.getNr_zawodnika());
        istniejacyZawodnik.setImie(zawodnicy.getImie());
        istniejacyZawodnik.setNazwisko(zawodnicy.getNazwisko());
        ZawodnikDAO.update(istniejacyZawodnik);
        return "redirect:/zawodnicy";
    }

    @RequestMapping("/deleteZ/{nr_zawodnika}")
    public String deleteZ(@PathVariable(name = "nr_zawodnika") int nr_zawodnika) {
        ZawodnikDAO.delete(nr_zawodnika);
        return "redirect:/zawodnicy";
    }

    //    Zajecia -----------------------------------------------------
    @Autowired
    private ZajeciaDAO zajeciaDAO;

    @RequestMapping("/zajecia")
    public String viewZajecia(Model model) {
        List<Zajecia> listZajecia = zajeciaDAO.list();
        model.addAttribute("listZajecia", listZajecia);
        return "zajecia";
    }

    @RequestMapping(value = "/saveZajecia", method = RequestMethod.POST)
    public String save(@ModelAttribute("zajecia") Zajecia zajecia) {
        zajeciaDAO.save(zajecia);
        return "redirect:/zajecia";
    }

    @RequestMapping(value = "/editZajecia", method = RequestMethod.POST)
    public String editZajecia(@ModelAttribute("zajecia") Zajecia zajecia) {
        Zajecia istniejaceZajecia = zajeciaDAO.get(zajecia.getNr_zajec());
        istniejaceZajecia.setNr_zajec(zajecia.getNr_zajec());
        istniejaceZajecia.setNazwa_zajec(zajecia.getNazwa_zajec());
        istniejaceZajecia.setLimit_miejsc(zajecia.getLimit_miejsc());
        istniejaceZajecia.setCzas_trwania(zajecia.getCzas_trwania());
        istniejaceZajecia.setData_rozpoczecia(zajecia.getData_rozpoczecia());
        istniejaceZajecia.setData_zakonczenia(zajecia.getData_zakonczenia());
        istniejaceZajecia.setNr_dyscypliny(zajecia.getNr_dyscypliny());
        zajeciaDAO.update(istniejaceZajecia);
        return "redirect:/zawodnicy";
    }

    @RequestMapping("/deleteZa/{nr_zajec}")
    public String deleteZa(@PathVariable(name = "nr_zajec") int nr_zajec) {
        zajeciaDAO.delete(nr_zajec);
        return "redirect:/zajecia";
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }

        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}