package com.example.UserApp.UserApp.Impl;

import com.example.UserApp.UserApp.DTO.UserDTO;
import com.example.UserApp.UserApp.Entity.UserEntity;
import com.example.UserApp.UserApp.Repository.UserRepository;
import com.example.UserApp.UserApp.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user)
    {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testuserid");
        UserEntity storedUser = userRepository.save(userEntity);
        UserDTO response = new UserDTO();
        BeanUtils.copyProperties(storedUser,response);

        return response;
    }
}
