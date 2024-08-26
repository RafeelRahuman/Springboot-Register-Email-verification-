package com.example.registerUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registerUser.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
