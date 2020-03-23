package com.projectjuni.projectjunidemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectjuni.projectjunidemo.models.User;
import com.projectjuni.projectjunidemo.repositories.UserRepository;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
//	
//	@Autowired
//	HeadRepository headRepository;

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
//    
//    @GetMapping
//    @RequestMapping("/head")
//    public List<Head> gethead(){
//        return headRepository.findAll();
//    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User s(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }
}
