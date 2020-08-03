package com.providence.TMS.Services;


import com.providence.TMS.Entities.Role;
import com.providence.TMS.Entities.User;
import com.providence.TMS.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
  private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);


    }


    public User getOne(String publicId){
        return userRepository.getOne(publicId);
    }


    public boolean isUserPresent(String email) {
        Optional<User> u = userRepository.findById(email);

        if (u.isPresent())
            return true;
        return false;


    }

    public List<User> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%"+name+"%");
    }
}
