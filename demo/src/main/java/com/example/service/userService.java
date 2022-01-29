package com.example.service;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UsersRepository;

import java.util.List;

@Service
public class userService {

    @Autowired
    UsersRepository usersRepository;

    public userService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findAllByFirst_name(String name){
        return usersRepository.findByfirstName(name);
    }
}