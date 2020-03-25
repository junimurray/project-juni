package com.projectjuni.projectjunidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectjuni.projectjunidemo.models.committees.Committee;
import com.projectjuni.projectjunidemo.models.committees.CommitteeFactory;
import com.projectjuni.projectjunidemo.models.committees.CommitteeType;

@RestController
public class CommitteeController {
	
	@Autowired
	private CommitteeFactory committeeFactory;
	
    @RequestMapping(value = "/committee", method = RequestMethod.GET)
    public List<? extends Committee> getCommittees(){
        return committeeFactory.getCommittee(CommitteeType.PRAISE_AND_WORSHIP);
    }
	
}
