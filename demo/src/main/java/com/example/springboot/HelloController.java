package com.example.springboot;


import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {
    public HelloController() {
    }

    @Autowired
    UsersRepository userRepo;

    @GetMapping({"/home"})
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> getAllItems(){
        List<User> items = userRepo.findAll();
        return new ResponseEntity<List<User>>(items, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    @ResponseBody
    public ResponseEntity<User> getItem(Long userId){
        Optional<User> item = userRepo.findById(userId);
        return new ResponseEntity<User>(item.get(), HttpStatus.OK);
    }

    @GetMapping("/users/{name}")
    @ResponseBody
    public ResponseEntity<User> getItemByName(String name){
        User items = userRepo.findByfirstName(name);
        System.out.println(items);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}