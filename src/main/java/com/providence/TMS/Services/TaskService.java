package com.providence.TMS.Services;


import com.providence.TMS.Entities.Task;
import com.providence.TMS.Entities.User;
import com.providence.TMS.Repositories.TaskRepository;
import com.providence.TMS.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> fineUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
