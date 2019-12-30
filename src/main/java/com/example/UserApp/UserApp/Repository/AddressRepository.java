package com.example.UserApp.UserApp.Repository;

import com.example.UserApp.UserApp.Entity.AddressEntity;
import com.example.UserApp.UserApp.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends CrudRepository<AddressEntity,Long> {

    public List<AddressEntity> findAllByUserDetails(UserEntity user);
}
