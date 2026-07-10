package com.example.SpringSecurityWithDatabase.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityWithDatabase.Entity.User;
import com.example.SpringSecurityWithDatabase.Repository.UserRepository;

@Service
public class UserDetailsServiceDB implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsername(username).get();
        System.out.println("Loaded user: "+user.getUsername()+" with hash: "+user.getPassword());
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
