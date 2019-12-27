package com.example.UserApp.UserApp.model.Response;

import com.example.UserApp.UserApp.DTO.AddressDTO;

import java.util.List;

public class UserDetailsResponseModel {
    private String userId;
    private String firstname;
    private String lastname;
    private String email;
    private List<AddressDetailsResponseModel> addresses;

    public List<AddressDetailsResponseModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDetailsResponseModel> addresses) {
        this.addresses = addresses;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
