package com.projectjuni.projectjunidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{

}
