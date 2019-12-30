package com.example.UserApp.UserApp.Service;

import com.example.UserApp.UserApp.DTO.AddressDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AddressService  {
    List<AddressDTO> getAddresses(String userId);

}
