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
        User user = userRepository.findById(id).get();
        if(user.getPassword().equals(oldPasswd)){
            user.setPassword(newPasswd);
            userRepository.save(user);
            return 0;
        }else{
            return 1;
        }
    }

    public int changeName(int id, String passwd, String newName){
        User user = userRepository.findById(id).get();
        if(user.getPassword().equals(passwd)){
            user.setName(newName);
            userRepository.save(user);
            return 0;
        }else{
            return 1;
        }
    }

}
