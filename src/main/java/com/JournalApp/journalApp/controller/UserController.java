package com.JournalApp.journalApp.controller;

import com.JournalApp.journalApp.entity.User;
import com.JournalApp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping
    public User getUser(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String username=auth.getName();
        System.out.println("YES Ok JI"+username);
        return userService.findByUserName(username);
    }



}
