package com.example.cryptoexchange.repository.user;


import com.example.cryptoexchange.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);

    User findUserByUsername(String username);

    User findUserByLastname(String lastname);

    List<User> findAll();


}
