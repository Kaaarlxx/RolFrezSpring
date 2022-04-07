package projekt.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projekt.projekt.models.Opinia;
import projekt.projekt.models.User;
import projekt.projekt.security.MyUserDetails;
import projekt.projekt.services.OpiniaService;


import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OpiniaController {

    public OpiniaController() {
    }

    @Autowired
    private OpiniaService service;

    @GetMapping("/opinie/lista_opinii")
    public String listaOpinii(Model model)
    {
        List<Opinia> lb=service.findAll();
        model.addAttribute("opinie", lb);
        return "/opinie/lista_opinii";
    }

    @GetMapping("/opinie/dodaj")
    public String nowaOpinia(Model model)
    {
        Opinia op = new Opinia();
        model.addAttribute("opinia", op);
        return "opinie/dodaj";
    }

    @PostMapping(value="/opinie/dodaj")
    public String dodajOpinie(@ModelAttribute("Opinia") Opinia opinia) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails u;
        u = (MyUserDetails) authentication.getPrincipal();
        Long userid = u.getId();
        User user = new User();
        user.setId(userid);
        opinia.setUser(user);
        service.save(opinia);
        return "redirect:/opinie/lista_opinii";
    }
    @GetMapping("/opinie/usun/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return "redirect:/opinie/lista_opinii";
    }

}
