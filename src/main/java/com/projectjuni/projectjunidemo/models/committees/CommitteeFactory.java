package com.projectjuni.projectjunidemo.models.committees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectjuni.projectjunidemo.repositories.CommitteeRepository;

@Component
public class CommitteeFactory {

	@Autowired
	private CommitteeRepository committeeRepository;

	public List<? extends Committee> getCommittee(CommitteeType type) {

		switch (type) {
		case PRAISE_AND_WORSHIP:
			List<PraiseAndWorshipCommittee> paw = committeeRepository.findAll();
			return paw;
		default:
			return null;
		}
	}

}
