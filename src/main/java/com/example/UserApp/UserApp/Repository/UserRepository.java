package com.example.UserApp.UserApp.Repository;

import com.example.UserApp.UserApp.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
     UserEntity findByEmail(String email);

}
