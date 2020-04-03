package com.projectjuni.projectjunidemo.models.committees;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.projectjuni.projectjunidemo.repositories.committees.DefaultRepository;
import com.projectjuni.projectjunidemo.repositories.committees.PraiseAndWorshipRepository;

@Component
public class CommitteeFactory {

	@Autowired
	private DefaultRepository defaultRepository;

	@Autowired
	private PraiseAndWorshipRepository praiseAndWorshipRepository;

	public List<? extends Committee> getCommittee(String type) {

		type = !EnumUtils.isValidEnum(CommitteeType.class, type) ? "DEFAULT" : type;
		CommitteeType committeeType = CommitteeType.valueOf(type);
		switch (committeeType) {
		case PRAISE_AND_WORSHIP:
			return praiseAndWorshipRepository.findAll();
		default:
			return defaultRepository.findAll();
		}
	}

}
