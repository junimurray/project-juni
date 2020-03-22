package com.projectjuni.projectjunidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
