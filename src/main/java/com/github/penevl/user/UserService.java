package com.github.penevl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<String> getUsers() {
        List users = new ArrayList<String>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
