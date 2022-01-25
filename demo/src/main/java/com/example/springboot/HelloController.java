package com.example.springboot;

import entity.users;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UsersRepository;
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
    public ResponseEntity<List<users>> getAllItems(){
        List<users> items = userRepo.findAll();
        return new ResponseEntity<List<users>>(items, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    @ResponseBody
    public ResponseEntity<users> getItem(Long userId){
        Optional<users> item = userRepo.findById(userId);
        return new ResponseEntity<users>(item.get(), HttpStatus.OK);
    }

    @GetMapping("/users/{name}")
    @ResponseBody
    public ResponseEntity<List<users>> getItemByName(String name){
        List<users> items = userRepo.findAllByFirstName(name);
        return new ResponseEntity<List<users>>(items, HttpStatus.OK);
    }

}