package com.example.UserApp.UserApp.Service;

import com.example.UserApp.UserApp.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public UserDTO createUser(UserDTO user);
    public UserDTO getUser(String email);

}
