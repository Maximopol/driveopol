package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//lolkek4@gmail.com

@Controller("/newregistration")
public class Reg2Controller {

    @Autowired
//    private UserService userService;
    private ClientService userService;
    /**
     * @param model
     * @return
     */
    @GetMapping("/newregistration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Client());

        return "public/reg2";
    }


    @PostMapping("/newregistration")
    public String greetingSubmit(@ModelAttribute Client client, BindingResult bindingResult, Model model) {
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "public/reg2";
        }
//        if(!EmailValidator.IsValidEmail(userForm.getUsername())){
//            model.addAttribute("passwordError", "У тебя почта странная");
//            return "registration";
//        }
//        if(!userForm.)


        System.out.println(client.toString());

        System.out.println(client.getPassword());
        System.out.println(client.getPasswordConfirm());

        if (!client.getPassword().equals(client.getPasswordConfirm())) {

            model.addAttribute("passwordError", "Пароли не совпадают");
            return "public/reg2";
        }
//        System.out.println("Слава украины");
//        User user = new User();
//        user.setUsername(client.getEmail());
//        user.setPassword(client.getPassword());
//        user.setPasswordConfirm(client.getConfirmPassword());

        System.out.println("Лул");
        if (!userService.saveUser(client)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");

            return "public/reg2";
        }
        System.out.println("ГЫЫЫЫЫЫЫЫ");
        return "public/login2";
    }
}
