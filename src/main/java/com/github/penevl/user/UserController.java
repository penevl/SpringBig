package com.github.penevl.user;

import com.github.javafaker.Faker;
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

    @RequestMapping(method = RequestMethod.PATCH,value = "/user/{id}/{oldPasswd}/{newPasswd}")
    public int changePasswd(@PathVariable int id,@PathVariable String oldPasswd,@PathVariable String newPasswd){
        return userService.changePasswd(id,oldPasswd,newPasswd);
    }

    @RequestMapping("/initUser")
    public void initUser(){
        Faker faker = new Faker();
        userService.addUser(new User(faker.name().username(),faker.name().firstName() + "@gmail.com","cuck",faker.phoneNumber().phoneNumber()));
        userService.addUser(new User(faker.name().username(),faker.name().firstName() + "@gmail.com","cunny",faker.phoneNumber().phoneNumber()));
        userService.addUser(new User(faker.name().username(),faker.name().firstName() + "@gmail.com","root",faker.phoneNumber().phoneNumber()));
        userService.addUser(new User(faker.name().username(),faker.name().firstName() + "@gmail.com","pussy",faker.phoneNumber().phoneNumber()));
    }

}
