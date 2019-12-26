package com.example.UserApp.UserApp.Impl;

import com.example.UserApp.UserApp.DTO.UserDTO;
import com.example.UserApp.UserApp.Entity.UserEntity;
import com.example.UserApp.UserApp.Repository.UserRepository;
import com.example.UserApp.UserApp.Service.UserService;
import com.example.UserApp.UserApp.Utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO user)
    {
        UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());

        if(storedUserDetails != null) throw new RuntimeException("Record Already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(utils.generateUserID(16));
        UserEntity storedUser = userRepository.save(userEntity);
        UserDTO response = new UserDTO();
        BeanUtils.copyProperties(storedUser,response);

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }

    @Override
    public UserDTO getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);
        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(userEntity,returnValue);

        return returnValue;
    }
}
