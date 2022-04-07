package projekt.projekt.controllers;

import org.eclipse.jdt.internal.compiler.problem.ProblemSeverities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projekt.projekt.models.User;
import projekt.projekt.services.UserService;


import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    public UserController() {
    }

    @Autowired
    private UserService service;

    @GetMapping("/kontakt")
    public String kontakt()
    {
        return "kontakt";
    }

    @GetMapping("/brakdostepu")
    public String brakdostepu()
    {
        return "brakdostepu";
    }
    @GetMapping("/logout")
    public String logout()
    {
        return "wylogowano";
    }
    @GetMapping("/wylogowano")
    public String wylogowano()
    {
        return "wylogowano";
    }

    @GetMapping("/register")
    public String nowyuser(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value="/register")
    public String dodajnowyuser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String loginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping(value="/login")
    public String logincheck(@ModelAttribute("user") User user) {
        Optional<User> user2= service.findById(user.getId());

        return "redirect:/";
    }



}
