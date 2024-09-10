package com.JournalApp.journalApp.service;

import com.JournalApp.journalApp.entity.User;
import com.JournalApp.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = userRepository.findByUserName(username);
            if (user != null) {
                System.out.println(user.getPassword() + user.getRoles() +"-----");

                return org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUserName())
                        .password(user.getPassword())
                        .roles(user.getRoles().toArray(new String[0]))
                        .build();

            }
            throw new UsernameNotFoundException("User Not Found ");
        }catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException();
        }
    }
}
