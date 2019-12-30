package com.example.UserApp.UserApp.Controllers;

import com.example.UserApp.UserApp.DTO.AddressDTO;
import com.example.UserApp.UserApp.DTO.UserDTO;
import com.example.UserApp.UserApp.Impl.UserServiceImplementation;
import com.example.UserApp.UserApp.Service.AddressService;
import com.example.UserApp.UserApp.Service.UserService;
import com.example.UserApp.UserApp.model.Request.UserDetailsRequestModel;
import com.example.UserApp.UserApp.model.Response.AddressDetailsResponseModel;
import com.example.UserApp.UserApp.model.Response.UserDetailsResponseModel;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

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

    @GetMapping(path = "/{id}")
    public List<AddressDetailsResponseModel> getUser(@PathVariable String id)
    {
        List<AddressDetailsResponseModel> returnVal = new ArrayList<>();

        List<AddressDTO> addresses = addressService.getAddresses(id);

        ModelMapper mapper = new ModelMapper();
        if(addresses!=null && !addresses.isEmpty())
        {
            java.lang.reflect.Type listType = new TypeToken<List<AddressDetailsResponseModel>>(){}.getType();
            returnVal = mapper.map(addresses,listType);
        }

        return returnVal;

    }
}
