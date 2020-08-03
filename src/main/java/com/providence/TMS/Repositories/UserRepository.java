package com.providence.TMS.Repositories;

import com.providence.TMS.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, String> {


    List<User> findByNameLike(String name);
}
