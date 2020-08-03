package com.providence.TMS.Controllers;


import com.providence.TMS.Entities.User;
import com.providence.TMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class registerController {
    @Autowired
   private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")

    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "register";
        }



        if (userService.isUserPresent(user.getEmail())){
            model.addAttribute("created",true);
            return "register";
        }

            userService.createUser(user);
            return  "dash";





    }

}
