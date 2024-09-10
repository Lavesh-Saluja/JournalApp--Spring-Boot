package com.JournalApp.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QuoteResponse {

    @JsonProperty("q")
    private String quote;

    public String toString(){
        return quote;
    }
}

