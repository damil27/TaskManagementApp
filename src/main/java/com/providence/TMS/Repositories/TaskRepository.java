package com.providence.TMS.Repositories;

import com.providence.TMS.Entities.Task;
import com.providence.TMS.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
