package com.JournalApp.journalApp.repository;

import com.JournalApp.journalApp.entity.ConfigJournalApp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepo extends MongoRepository<ConfigJournalApp, ObjectId> {

}



