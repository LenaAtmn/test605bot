package com.lenech.lab4.controller;
import com.lenech.lab4.model.User;
import com.lenech.lab4.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/in")
public class UserController {
    private UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserId(@PathVariable(value = "id")int userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id")int userId)
            throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId,
                                             @Valid @RequestBody User userdetails)
            throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()-> new
                ResourceNotFoundException("User not found"));
        user.setName(userdetails.getName());
        user.setLink(userdetails.getLink());
        user.setBanstatus(userdetails.getBanstatus());

        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
