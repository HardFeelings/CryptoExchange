package com.example.cryptoexchange.repository.user;


import com.example.cryptoexchange.entity.User;
import com.example.cryptoexchange.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

    Long findIdByUsername(String username);

    List<User> findAll();
}
