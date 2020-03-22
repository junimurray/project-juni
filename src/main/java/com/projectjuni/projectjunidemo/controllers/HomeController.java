package com.projectjuni.projectjunidemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectjuni.projectjunidemo.models.User;
import com.projectjuni.projectjunidemo.repositories.UserRepository;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository userRepository;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }
    
    @GetMapping
    @RequestMapping("/user")
    public List<User> get(){
        return userRepository.findAll();
    }
}
