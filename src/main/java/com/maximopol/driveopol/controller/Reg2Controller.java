package com.maximopol.driveopol.controller;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.service.ClientService;
import com.maximopol.driveopol.validator.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//lolkek4@gmail.com

@Controller("/registration")
public class Reg2Controller {
    private static Logger logger = LogManager.getLogger(Reg2Controller.class);

    @Autowired
    private ClientService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Client());
        logger.info("Someone opened the registration page");
        return "public/reg2";
    }

    @PostMapping("/registration")
    public String greetingSubmit(@ModelAttribute Client client, BindingResult bindingResult, Model model) {
        String result = "";
        if (bindingResult.hasErrors()) {
            return "public/reg2";
        }
        if (!EmailValidator.IsValidEmail(client.getEmail())) {
            result = "У тебя почта странная\n";
        }

        if (!client.getPassword().equals(client.getPasswordConfirm())) {
            result += "Пароли не совпадают";
        }

        if (!result.equals("")) {
            logger.warn(result);
            model.addAttribute("passwordError", result);
            return "public/reg2";
        }

        if (!userService.saveUser(client)) {
            logger.warn("Пользователь с такой почтой уже существует!");
            model.addAttribute("passwordError", "Пользователь с такой почтой уже существует!");
            return "public/reg2";
        }
        logger.info("New user with mail " + client.getEmail() + " added successfully");
        return "redirect:login";
    }
}
