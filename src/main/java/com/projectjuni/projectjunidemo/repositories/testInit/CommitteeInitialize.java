package com.projectjuni.projectjunidemo.repositories.testInit;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.projectjuni.projectjunidemo.models.committees.PraiseAndWorshipCommittee;
import com.projectjuni.projectjunidemo.repositories.committees.PraiseAndWorshipRepository;

@Component
public class CommitteeInitialize implements InitializeDB {
	
	@Autowired
	private PraiseAndWorshipRepository praiseAndWorshipRepository;
	
	@Override
	public void initialize() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/static/committee_sample.json"));
		PraiseAndWorshipCommittee pawc = new Gson().fromJson(br, PraiseAndWorshipCommittee.class);
		praiseAndWorshipRepository.saveAndFlush(pawc);
	}

}
