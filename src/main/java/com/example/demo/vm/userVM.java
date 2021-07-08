package com.example.demo.vm;

import com.example.demo.Model.User;
import lombok.Data;

@Data
public class userVM {

    private String username;

    private String password;


    public userVM(User user) {
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
    }

}
