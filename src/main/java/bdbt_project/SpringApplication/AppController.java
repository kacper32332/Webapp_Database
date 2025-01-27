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

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Autowired
    private AdresyDAO AdresDAO;

    @RequestMapping("/adresy")
    public String viewHomePage(Model model) {
        List<Adresy> listAdresy = AdresDAO.list();
        model.addAttribute("listAdresy", listAdresy);
        return "adresy";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Adresy adresy = new Adresy();
        model.addAttribute("adresy", adresy);
        return "new_form";
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

    @RequestMapping(value = "/getAdres/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Adresy getAdres(@PathVariable("id") int id) {
        return AdresDAO.get(id);
    }


    @RequestMapping("/delete/{nr_adresu}")
    public String delete(@PathVariable(name = "nr_adresu") int nr_adresu) {
        AdresDAO.delete(nr_adresu);
        return "redirect:/adresy";
    }

    @Autowired
    private ZawodnicyDAO ZawodnikDAO;

    @RequestMapping("/zawodnicy")
    public String viewZawodnicyPage(Model model) {
        List<Zawodnicy> listZawodnicy = ZawodnikDAO.list();
        model.addAttribute("listZawodnicy", listZawodnicy);
        return "zawodnicy";
    }


    @RequestMapping(value = "/saveZawodnik", method = RequestMethod.POST)
    public String saveZawodnik(@ModelAttribute("zawodnicy") Zawodnicy zawodnicy) {
        ZawodnikDAO.save(zawodnicy);
        return "redirect:/zawodnicy";
    }

    @RequestMapping(value = "/editZawodnik", method = RequestMethod.POST)
    public String editZawodnik(@ModelAttribute("zawodnicy") Zawodnicy zawodnicy) {
        Zawodnicy istniejacyZawodnik = ZawodnikDAO.get(zawodnicy.getNr_zawodnika());
        istniejacyZawodnik.setNr_zawodnika(zawodnicy.getNr_zawodnika());
        istniejacyZawodnik.setImie(zawodnicy.getImie());
        istniejacyZawodnik.setNazwisko(zawodnicy.getNazwisko());
        istniejacyZawodnik.setPlec(zawodnicy.getPlec());
        istniejacyZawodnik.setEmail(zawodnicy.getEmail());
        istniejacyZawodnik.setNr_telefonu(zawodnicy.getNr_telefonu());
        istniejacyZawodnik.setData_urodzenia(zawodnicy.getData_urodzenia());
        istniejacyZawodnik.setNr_adresu(zawodnicy.getNr_adresu());
        ZawodnikDAO.update(istniejacyZawodnik);
        return "redirect:/zawodnicy";
    }

    @RequestMapping(value = "/getZawodnik/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Zawodnicy getZawodnik(@PathVariable("id") int id) {
        return ZawodnikDAO.get(id);
    }


    @RequestMapping("/deleteZawodnik/{nr_zawodnika}")
    public String deleteZawodnik(@PathVariable(name = "nr_zawodnika") int nr_zawodnika) {
        ZawodnikDAO.delete(nr_zawodnika);
        return "redirect:/zawodnicy";
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