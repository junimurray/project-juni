package com.projectjuni.projectjunidemo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	
	public boolean existsByVolunteerId(UUID volunteerId);

}
