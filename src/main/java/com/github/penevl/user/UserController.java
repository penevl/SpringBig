package com.github.penevl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public void createUser(@RequestBody User user){
        userService.addUser(user);
    }
    
    @RequestMapping("/initUser")
    public void initUser(){
        userService.addUser(new User(0,"TestUser","testUser@gmail.com","root",886631063));
    }

}
