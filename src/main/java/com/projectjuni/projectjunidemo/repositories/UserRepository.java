package com.projectjuni.projectjunidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.Volunteer;

public interface UserRepository extends JpaRepository<Volunteer, Long>{

}
