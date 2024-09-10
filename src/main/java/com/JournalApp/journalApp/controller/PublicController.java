package com.JournalApp.journalApp.controller;

import com.JournalApp.journalApp.entity.User;
import com.JournalApp.journalApp.service.QuoteService;
import com.JournalApp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuoteService quoteService;
//    @GetMapping("/create-entry-page")
//    public String getCreateEntryPage(Model model) {
//        model.addAttribute("createJournalEntry",new JournalEntryController());
//        return "createJournalEntry";  // This should match the name of your HTML file without the extension
//    }
//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAll();
//    }
    @PostMapping("register")
    public void createUser(@RequestBody User user){
        System.out.println("Hello "+user.getUserName());
        userService.saveNewEntry(user);
    }

    @GetMapping("get-quotes")
    public ResponseEntity<?> getQuotes(){
        ArrayList st=new ArrayList<>((quoteService.getQuote()));
        return new ResponseEntity<>( st, HttpStatus.OK );


    }
    @GetMapping("/admins")
    public ResponseEntity<?> getAdmins(){
        try{
            List<User> users=userService.getAdmins();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
