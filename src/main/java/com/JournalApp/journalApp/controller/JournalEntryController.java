package com.JournalApp.journalApp.controller;

import com.JournalApp.journalApp.entity.JournalEntry;
import com.JournalApp.journalApp.entity.User;
import com.JournalApp.journalApp.service.JournalEntryService;
import com.JournalApp.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

@Autowired
private JournalEntryService journalEntryService;
@Autowired
private UserService userService;
@GetMapping
public List<JournalEntry> getJournal(){
    System.out.println("Leee");
    return journalEntryService.getAll();
}

@PostMapping("/create-entry")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
    System.out.println("Hello ji");
    Authentication auth= SecurityContextHolder.getContext().getAuthentication();
    String userName=auth.getName();
        journalEntryService.saveEntry(myEntry,userName);
        return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
}

@GetMapping("id/{id}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable ObjectId id){
    System.out.println("Hello ji");
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String userName=auth.getName();
        User user=userService.findByUserName(userName);
     List<JournalEntry> list=user.getJournalEntries();
    Optional<JournalEntry> j= list.stream().filter(entry-> entry.getId().equals(id)).findFirst();
    if(j.isPresent()){
        return new ResponseEntity<>(j,HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@GetMapping("{userName}")
public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
    User user= userService.findByUserName(userName);
    List<JournalEntry> all=user.getJournalEntries();
    if(all !=null && !all.isEmpty()){
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

}
