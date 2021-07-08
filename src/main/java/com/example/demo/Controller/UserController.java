package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import com.example.demo.vm.userVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/1.0/")
@RestController
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.findAll());

    }
    @GetMapping("/users/{username}")
    userVM getUser(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return new userVM(user);
    }
}
