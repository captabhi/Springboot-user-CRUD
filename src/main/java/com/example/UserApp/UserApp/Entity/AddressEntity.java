package com.example.UserApp.UserApp.Entity;

import com.example.UserApp.UserApp.DTO.UserDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "address")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 16, nullable = false)
    private String addressId;
    @Column(length = 20, nullable = false)
    private String city;
    @Column(length = 20, nullable = false)
    private String country;
    @Column(length = 30, nullable = false)
    private String streetname;
    @Column(length = 20, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity userEntity;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserEntity getUserDTO() {
        return userEntity;
    }

    public void setUserDTO(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


}
