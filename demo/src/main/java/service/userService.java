package service;

import entity.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsersRepository;

import java.util.List;

@Service
public class userService {

    @Autowired
    UsersRepository usersRepository;

    public userService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<users> findAll(){
        return usersRepository.findAll();
    }

    public List<users> findAllByFirstName(String name){
        return usersRepository.findAllByFirstName(name);
    }
}