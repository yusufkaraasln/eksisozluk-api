package com.springboot.boilerplate.services;


import com.springboot.boilerplate.dtos.UserDTO;
import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    public UserDTO getUserDetails() {

        User user = authService.getUser().getData();

        UserDTO result = new UserDTO();

        result.setDetails(user);
        result.setEntries(user.getEntries());


        return result;

    }


}
