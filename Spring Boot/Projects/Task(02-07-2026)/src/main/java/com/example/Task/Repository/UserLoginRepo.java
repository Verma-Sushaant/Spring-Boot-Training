package com.example.Task.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task.Entity.UserLogin;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer>{
    Optional<UserLogin> findByName(String name);
    Optional<UserLogin> findByUsername(String username);
}
