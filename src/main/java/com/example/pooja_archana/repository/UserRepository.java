package com.example.pooja_archana.repository;

import com.example.pooja_archana.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    public UserEntity findByEmail(String email);
}
