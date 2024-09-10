package com.JournalApp.journalApp.service;

import com.JournalApp.journalApp.entity.User;
import com.JournalApp.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public void saveNewEntry(User user){
        try{
            user.setRoles(List.of("USER"));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            System.out.println("REACH");
        }catch (Exception e){
            log.error("ERROR OCCURED for user name {} {}",user.getUserName(),e.getMessage());
        }

    }
    public void saveEntry(User user){
        userRepository.save(user);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
//    public Optional<User> findById(ObjectId id){
//        return userRepository.findById(id);
//    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> getAdmins(){
        Query query=new Query();
        query.addCriteria(Criteria.where("roles").in("ADMIN"));
        return mongoTemplate.find(query,User.class);
    }

}
