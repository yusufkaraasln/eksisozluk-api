package com.springboot.boilerplate.security;


import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        Optional<User> userRes = userRepo.findById(Integer.parseInt(user_id));
        if (userRes.isEmpty())
            throw new EntityNotFoundException();
        User user = userRes.get();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getUserType());
        return new org.springframework.security.core.userdetails.User(
                user_id,
                user.getPassword(),
                Collections.singletonList(authority));
    }
}
