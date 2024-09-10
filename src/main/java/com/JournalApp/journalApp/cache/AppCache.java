package com.JournalApp.journalApp.cache;

import com.JournalApp.journalApp.entity.ConfigJournalApp;
import com.JournalApp.journalApp.repository.ConfigJournalAppRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    public Map<String,String> APP_CACHE=new HashMap<>();


    @PostConstruct
    public void init(){
        APP_CACHE=new HashMap<>();
        List<ConfigJournalApp> all=configJournalAppRepo.findAll();
        for(ConfigJournalApp configJournalApp:all){
            APP_CACHE.put(configJournalApp.getKey(), configJournalApp.getValue());
        }
    }

}
