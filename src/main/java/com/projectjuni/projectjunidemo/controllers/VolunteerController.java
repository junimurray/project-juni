package com.projectjuni.projectjunidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectjuni.projectjunidemo.models.Volunteer;
import com.projectjuni.projectjunidemo.repositories.VolunteerRepository;

@RestController
public class VolunteerController {

	@Autowired
	VolunteerRepository volunteerRepository;
	
    @RequestMapping(value = "/volunteers", method = RequestMethod.GET)
    public List<Volunteer> getVolunteers(){
        return volunteerRepository.findAll();
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Volunteer saveVolunteer(@RequestBody Volunteer volunteer){
        return volunteerRepository.saveAndFlush(volunteer);
    }
}
