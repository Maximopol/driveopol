package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.Role;
import com.maximopol.driveopol.entity.User;
import com.maximopol.driveopol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * @param model
     * @return
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }


    @PostMapping("/registration")
    public String greetingSubmit(@ModelAttribute Client client, BindingResult bindingResult, Model model) {
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        if(!EmailValidator.IsValidEmail(userForm.getUsername())){
//            model.addAttribute("passwordError", "У тебя почта странная");
//            return "registration";
//        }
//        if(!userForm.)


        System.out.println(client.toString());


        if (!client.getPassword().equals(client.getConfirmPassword())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        System.out.println("Слава украины");
        User user = new User();
        user.setUsername(client.getEmail());
        user.setPassword(client.getPassword());
        user.setPasswordConfirm(client.getConfirmPassword());
        Role role = new Role();
        role.setName("USER");
        HashSet<Role> set = new HashSet<>();
        set.add(role);

        user.setRoles(set);
        System.out.println("Лул");
        if (!userService.saveUser(user)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");

            return "registration";
        }
        System.out.println("ГЫЫЫЫЫЫЫЫ");
        return "redirect:/login";
    }
}
