package com.JournalApp.journalApp.repository;

import com.JournalApp.journalApp.entity.JournalEntry;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {


}
