package com.example.Online_store.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        int User_id = Integer.valueOf(id);
        return userRepository.findById(User_id).orElse(null);
    }

    public User addUser(User user){

        return userRepository.save(user);
    }

    public void deleteUser(String id){
        int User_id = Integer.valueOf(id);
        userRepository.deleteById(User_id);

    }

    public void updateUser(String id, User data){
        int User_id = Integer.valueOf(id);
        User user = userRepository.findById(User_id).orElse(null);

        if (user != null){
            user.setUserName(data.getUserName());
            user.setEmail(data.getPassword());
            user.setPhone(data.getPhone());
            user.setPassword(data.getPassword());
            userRepository.save(user);
            }
        }

    }

