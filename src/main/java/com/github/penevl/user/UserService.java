package com.github.penevl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUser(int id) {
        try{return  userRepository.findById(id).get();
        }catch (NoSuchElementException e){
            return new User();
        }
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

    public int changeEmail(int id, String passwd, String newEmail){
        User user = userRepository.findById(id).get();
        if(user.getPassword().equals(passwd)){
            user.setEmail(newEmail);
            userRepository.save(user);
            return 0;
        }else{
            return 1;
        }
    }

    public int changePhone(int id, String passwd, String newPhone) {
        User user = userRepository.findById(id).get();
        if(user.getPassword().equals(passwd)){
            user.setPhone(newPhone);
            userRepository.save(user);
            return 0;
        }else{
            return 1;
        }
    }

    public int deleteUser(int id, String passwd) {
        try{
            userRepository.findById(id).get();
        }catch (NoSuchElementException e){
            return 2;
        }
        if(userRepository.findById(id).get().getPassword().equals(passwd)){
            userRepository.deleteById(id);
            return 0;
        }else {
            return 1;
        }
    }
}
