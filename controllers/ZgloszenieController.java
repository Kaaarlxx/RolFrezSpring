package projekt.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projekt.projekt.ActUser;
import projekt.projekt.models.Typy_zgloszen;
import projekt.projekt.models.User;
import projekt.projekt.models.Zgloszenie;
import projekt.projekt.security.MyUserDetails;
import projekt.projekt.services.Typy_zgloszenService;


import org.springframework.stereotype.Controller;
import projekt.projekt.services.ZgloszenieService;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class ZgloszenieController {



    @Autowired
    private ZgloszenieService service;
    @Autowired
    private Typy_zgloszenService service2;

    @GetMapping("/zgloszenie/moje")
    public String zgloszenieMoje(Model model) {
        List<Zgloszenie> zgloszenia;
        zgloszenia = service.findAll();
        Long userid = ActUser.getUserId();
        model.addAttribute("zgloszenia", zgloszenia);
        model.addAttribute("actuser", userid);
        return "/zgloszenie/moje";
    }


    @GetMapping("/zgloszenie/dodaj")
    public String zgloszenieAdd(Model model) {
        List<Typy_zgloszen> typy;
        typy = service2.findAll();
        Zgloszenie zgloszenie = new Zgloszenie();
        model.addAttribute("zgloszenie", zgloszenie);
        model.addAttribute("typy", typy);
        return "/zgloszenie/dodaj";
    }

    @GetMapping("/zgloszenie/wszystkie")
    public String zgloszenieWszystkie(Model model) {
        List<Zgloszenie> zgloszenia = service.findAll();
        model.addAttribute("zgloszenia", zgloszenia);
        return "/zgloszenie/wszystkie";
    }

    @GetMapping("/zgloszenie/nowe")
    public String zgloszeniaNowe(Model model) {
        List<Zgloszenie> zgloszenia = service.findAll();
        model.addAttribute("zgloszenia", zgloszenia);
        return "/zgloszenie/nowe";
    }


    @PostMapping(value="/zgloszenie/dodaj")
    public String zgloszenieAddPost(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie,@ModelAttribute("typ") Long typ) {

        Long userid = ActUser.getUserId();
        User user = new User();
        user.setId(userid);
        zgloszenie.setUser(user);
        Typy_zgloszen type = new Typy_zgloszen();
        type.setId(typ);
        zgloszenie.setTyp(type);
        service.save(zgloszenie);
        return "redirect:/";
    }

    @GetMapping("/zgloszenie/usun/{id}")
    public String deleteZgloszenie(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return "redirect:/zgloszenie/moje";
    }

    @GetMapping("/zgloszenie/wycen/{id}")
    public String wycenZgloszenie(@PathVariable(name = "id") Long id,Model model) {
        Optional<Zgloszenie> zgloszenieOpt = service.findById(id);
        Zgloszenie zgloszenie = zgloszenieOpt.get();
            model.addAttribute("zgloszenie", zgloszenie);
            return "/zgloszenie/wycen";
    }
    @PostMapping(value="/zgloszenie/wycen")
    public String wycenPost(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie2) {
        Optional<Zgloszenie> zgloszenieOpt = service.findById(zgloszenie2.getId());
        Zgloszenie zgloszenie = zgloszenieOpt.get();
        zgloszenie.setKomentarzadmina(zgloszenie2.getKomentarzadmina());
        zgloszenie.setCena(zgloszenie2.getCena());
        service.save(zgloszenie);
        return "redirect:/zgloszenie/nowe";
    }

    @GetMapping("/zgloszenie/edytuj/{id}")
    public String editZgloszenie(@PathVariable(name = "id") Long id,Model model) {
        List<Typy_zgloszen> typy;
        typy = service2.findAll();
        Optional<Zgloszenie> zgloszenieOpt = service.findById(id);
        Zgloszenie zgloszenie = zgloszenieOpt.get();
        if(ActUser.getUserId()!=zgloszenie.getUser().getId()) {
            if (ActUser.getRole()!="admin") {
                return "redirect:/brakdostepu";
            }
        }
        else{
            model.addAttribute("zgloszenie", zgloszenie);
            model.addAttribute("typy", typy);
            return "/zgloszenie/edytuj";
        }
        return "/zgloszenie/edytuj";
    }
    @PostMapping(value="/zgloszenie/edytuj")
    public String editZgloszeniePost(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie,@ModelAttribute("typ") Long typ) {

        Long userid = ActUser.getUserId();
        User user = new User();
        user.setId(userid);
        zgloszenie.setUser(user);
        Typy_zgloszen type = new Typy_zgloszen();
        type.setId(typ);
        zgloszenie.setTyp(type);
        service.save(zgloszenie);
        return "redirect:/zgloszenie/moje";
    }

    @GetMapping("/zgloszenie/zaakceptuj/{id}")
    public String zaakceptujZgloszenie(@PathVariable(name = "id") Long id) {
        Optional<Zgloszenie> zgloszenieOptional = service.findById(id);
        Zgloszenie zgloszenie = zgloszenieOptional.get();
        if(ActUser.getUserId()!=zgloszenie.getUser().getId()) {
            if (!ActUser.getRole().equals("admin")) {
                return "redirect:/brakdostepu";
            }
            else{
                zgloszenie.setStatus("Zaakceptowano");
                service.save(zgloszenie);
                System.out.println(zgloszenie.getStatus());
                return "redirect:/zgloszenie/wszystkie";
            }
        }
        else{
            zgloszenie.setStatus("Zaakceptowano");
            service.save(zgloszenie);
        }
            return "redirect:/zgloszenie/moje";
    }

    @GetMapping("/zgloszenie/odrzuc/{id}")
    public String odrzucZgloszenie(@PathVariable(name = "id") Long id) {

        Optional<Zgloszenie> zgloszenieOptional = service.findById(id);
        Zgloszenie zgloszenie = zgloszenieOptional.get();
        if(ActUser.getUserId()!=zgloszenie.getUser().getId()) {
            if (!ActUser.getRole().equals("admin")) {
                return "redirect:/brakdostepu";
            }
            else{
                zgloszenie.setStatus("Odrzucono");
                service.save(zgloszenie);
                System.out.println(zgloszenie.getStatus());
                return "redirect:/zgloszenie/wszystkie";
            }
        }
        else{
            zgloszenie.setStatus("Odrzucono");
            service.save(zgloszenie);
        }
        return "redirect:/zgloszenie/moje";
    }


}
