package com.example.hakaton.repository;

import com.example.hakaton.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Repository
@CrossOrigin(origins = "*",
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE },
        maxAge = 3600)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
