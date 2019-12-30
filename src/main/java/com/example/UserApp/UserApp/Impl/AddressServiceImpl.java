package com.example.UserApp.UserApp.Impl;

import com.example.UserApp.UserApp.DTO.AddressDTO;
import com.example.UserApp.UserApp.Entity.AddressEntity;
import com.example.UserApp.UserApp.Entity.UserEntity;
import com.example.UserApp.UserApp.Repository.AddressRepository;
import com.example.UserApp.UserApp.Repository.UserRepository;
import com.example.UserApp.UserApp.Service.AddressService;
import org.apache.tomcat.jni.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<AddressDTO> getAddresses(String userId)
    {
        List<AddressDTO> returnVal = new ArrayList<>();

        UserEntity user = userRepository.findByUserId(userId);
        if(user == null)
        {
            return returnVal;
        }
        ModelMapper  modelMapper = new ModelMapper();
        Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(user);
        for(AddressEntity addressEntity:addresses)
        {
            returnVal.add(modelMapper.map(addressEntity,AddressDTO.class));
        }
        return returnVal;
    }
}
