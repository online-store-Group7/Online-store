package com.example.Online_store.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path= "users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String filter){
        return userService.getUser();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
         userService.addUser(user);
    }



    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void delUser(@PathVariable String id){
         userService.deleteUser(id);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User data){
        userService.updateUser(id, data);
    }


}
