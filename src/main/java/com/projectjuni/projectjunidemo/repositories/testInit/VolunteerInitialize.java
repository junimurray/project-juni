package com.projectjuni.projectjunidemo.repositories.testInit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.projectjuni.projectjunidemo.models.Volunteer;
import com.projectjuni.projectjunidemo.repositories.VolunteerRepository;

@Component
public class VolunteerInitialize implements InitializeDB {

	@Autowired
	private VolunteerRepository volunteerRepository;
	
	@Override
	public void initialize() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/static/volunteer_sample.json"));
		Type listType = new TypeToken<ArrayList<Volunteer>>(){}.getType();
		List<Volunteer> listVolunteers = new Gson().fromJson(br, listType);
		volunteerRepository.saveAll(listVolunteers);
	}

}
