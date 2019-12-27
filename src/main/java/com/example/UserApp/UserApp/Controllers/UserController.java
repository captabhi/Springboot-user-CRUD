package com.example.UserApp.UserApp.Controllers;

import com.example.UserApp.UserApp.DTO.UserDTO;
import com.example.UserApp.UserApp.Impl.UserServiceImplementation;
import com.example.UserApp.UserApp.Service.UserService;
import com.example.UserApp.UserApp.model.Request.UserDetailsRequestModel;
import com.example.UserApp.UserApp.model.Response.UserDetailsResponseModel;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userRequestObject)
    {
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();
//        UserDTO userDto = new UserDTO();
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDto = modelMapper.map(userRequestObject,UserDTO.class);
        UserDTO createdUser = userService.createUser(userDto);
        userResponse = modelMapper.map(createdUser,UserDetailsResponseModel.class);
        return userResponse;
    }

    @GetMapping
    public String getUser()
    {
        return "Get user was called";
    }
}
