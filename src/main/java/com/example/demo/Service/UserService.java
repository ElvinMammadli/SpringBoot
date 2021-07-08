package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }
    public List<User> findAll(){
        List<User> users= userRepository.findAll();
        return users;
    }
    public User getByUsername(String username) {
        User inDB = userRepository.findByUsername(username);
        return inDB;
    }

}
