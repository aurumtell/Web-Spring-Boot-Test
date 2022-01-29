package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    User findByfirstName(String firstName);

    @Query("select u from User u where u.email like '%@email.ru%'")//если этого мало можно написать
        //собственный запрос на языке похожем на SQL
    List<User> findWhereEmailIsGmail(String email);


}