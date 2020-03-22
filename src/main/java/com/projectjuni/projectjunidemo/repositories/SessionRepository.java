package com.projectjuni.projectjunidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
