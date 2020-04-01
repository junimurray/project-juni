package com.projectjuni.projectjunidemo.repositories.committees;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.committees.Committee;

public interface CommitteeRepository<T extends Committee> extends JpaRepository<T, UUID> {
	boolean existsByName(String name);
}
