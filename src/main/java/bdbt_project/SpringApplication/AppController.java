package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

//    @RequestMapping("/edit/{nr_adresu}")
//    public ModelAndView showEditForm(@PathVariable(name = "nr_adresu") int nr_adresu) {
//        ModelAndView mav = new ModelAndView("edit_form");
//        Adresy adresy = AdresDAO.get(nr_adresu);
//        mav.addObject("adresy", adresy);
//        return mav;
//    }

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

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    public String update(@PathVariable("id") int id, @ModelAttribute("adresy") Adresy adresy) {
//        adresy.setNr_adresu(id); // Ensure the ID is set in the object
//        AdresDAO.update(adresy);
//        return "redirect:/adresy";
//    }

    @RequestMapping("/delete/{nr_adresu}")
    public String delete(@PathVariable(name = "nr_adresu") int nr_adresu) {
        AdresDAO.delete(nr_adresu);
        return "redirect:/adresy";
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