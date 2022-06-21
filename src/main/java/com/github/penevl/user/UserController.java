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

    @RequestMapping(method = RequestMethod.PATCH,value = "/user/passChange/{id}/{oldPasswd}/{newPasswd}")
    public int changePasswd(@PathVariable int id,@PathVariable String oldPasswd,@PathVariable String newPasswd){
        return userService.changePasswd(id,oldPasswd,newPasswd);
    }

    @RequestMapping(method = RequestMethod.PATCH,value = "/user/nameChange/{id}/{passwd}/{newName}")
    public int changeName(@PathVariable int id,@PathVariable String passwd,@PathVariable String newName){
        return userService.changeName(id,passwd,newName);
    }

    @RequestMapping(method = RequestMethod.PATCH,value = "/user/emailChange/{id}/{passwd}/{newEmail}")
    public int changeEmail(@PathVariable int id,@PathVariable String passwd,@PathVariable String newEmail){
        return userService.changeEmail(id,passwd,newEmail);
    }

    @RequestMapping(method = RequestMethod.PATCH,value = "/user/phoneChange/{id}/{passwd}/{newPhone}")
    public int changePhone(@PathVariable int id,@PathVariable String passwd,@PathVariable String newPhone){
        return userService.changePhone(id,passwd,newPhone);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/user/{id}/{passwd}")
    public int deleteUser(@PathVariable int id,@PathVariable String passwd){
        return userService.deleteUser(id,passwd);
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
