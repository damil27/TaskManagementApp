package com.providence.TMS.Controllers;

import com.providence.TMS.Entities.Task;
import com.providence.TMS.Services.TaskService;
import com.providence.TMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class taskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public  String taskform(String user_id, Model model, HttpSession session)
    {
        session.setAttribute("user_id",user_id);
        model.addAttribute("task",new Task());

        return "/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session)
    {
    if(bindingResult.hasErrors()){
        return"/taskform";
    }
    String user_id = (String) session.getAttribute("user_id");
    taskService.addTask(task,userService.getOne(user_id));
    return "redirect:/users";
    }


}
