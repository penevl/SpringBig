package com.github.penevl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    public int changePasswd(int id, String oldPasswd, String newPasswd){
        User u = userRepository.findById(id).get();
        if(u.getPassword().equals(oldPasswd)){
            u.setPassword(newPasswd);
            userRepository.save(u);
            return 0;
        }else{
            return 1;
        }
    }

}
