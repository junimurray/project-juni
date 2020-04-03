package com.projectjuni.projectjunidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectjuni.projectjunidemo.models.committees.Committee;
import com.projectjuni.projectjunidemo.models.committees.CommitteeFactory;
import com.projectjuni.projectjunidemo.repositories.committees.PraiseAndWorshipRepository;

@RestController
public class CommitteeController {
	
	@Autowired
	private CommitteeFactory committeeFactory;
	
	@Autowired
	private PraiseAndWorshipRepository praiseAndWorshipRepository;
	
    @GetMapping(path = "/committee")
    public List<? extends Committee> getCommittees(@RequestParam(required = false) String type){
        return committeeFactory.getCommittee(type);
    }
	
}
