package com.github.daanielowsky.RecruitmentAssistant.controllers;

import com.github.daanielowsky.RecruitmentAssistant.dto.UserDTO;
import com.github.daanielowsky.RecruitmentAssistant.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String mainPage(){
        if(userService.getLoggedUser() != null){
            return "redirect:/candidates";
        }
        return "mainPage";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "loginPage";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "registerPage";
    }

    @PostMapping("/register")
    public String registeringUser(@Valid @ModelAttribute("user") UserDTO form, BindingResult result){
        if(result.hasErrors()){
            return "registerPage";
        }
        if (!checkPasswordEquality(form)) {
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "registerPage";
        }

        if (!checkIsUsernameAvaiable(form)) {
            result.rejectValue("username", null, "Nazwa użytkownika już zajęta.");
            return "registerPage";
        }
        userService.creatingTheUser(form);

        return "redirect:/";


    }

    private boolean checkIsUsernameAvaiable(UserDTO form) {
        boolean check = userService.findUser(form.getUsername());
        if (check == true){
            return true;
        }
        return false;
    }

    private boolean checkPasswordEquality(UserDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }

}
