package com.projectjuni.projectjunidemo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjuni.projectjunidemo.models.committees.Committee;
import com.projectjuni.projectjunidemo.models.committees.PraiseAndWorshipCommittee;

public interface CommitteeRepository extends JpaRepository<PraiseAndWorshipCommittee, UUID> {

}
