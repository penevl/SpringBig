package com.github.penevl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public void createUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping("/initUser")
    public void initUser(){
        userService.addUser(new User(0,"TestUser","testUser@gmail.com","root",886631063));
    }

}
