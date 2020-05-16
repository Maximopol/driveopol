package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.User;
import com.maximopol.driveopol.service.UserService;
import com.maximopol.driveopol.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    /**
     *
     * @param userForm
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        if(!EmailValidator.IsValidEmail(userForm.getUsername())){
//            model.addAttribute("passwordError", "У тебя почта странная");
//            return "registration";
//        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/login";
    }
}
