package com.providence.TMS.Controllers;


import com.providence.TMS.Entities.User;
import com.providence.TMS.Services.TaskService;
import com.providence.TMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class profileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal)
    {
        String publicId = principal.getName();
        User user = userService.getOne(publicId);
        model.addAttribute("tasks",taskService.fineUserTask(user));
        return "profile";
    }

}
