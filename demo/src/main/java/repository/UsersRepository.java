package repository;

import entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<users, Long> {
    List<users> findAllByFirstName(String firstName);

    @Query("select u from Users u where u.email like '%@email.ru%'")//если этого мало можно написать
        //собственный запрос на языке похожем на SQL
    List<users> findWhereEmailIsGmail();

    List<users> findAll();
}