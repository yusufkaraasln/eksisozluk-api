package com.springboot.boilerplate.repositories;

import com.springboot.boilerplate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findFirstByEmail(String email);

    Optional<User> findById(Integer id);


    User getUserByUsername(String username);
}
