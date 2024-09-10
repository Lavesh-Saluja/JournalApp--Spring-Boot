package com.JournalApp.journalApp.service;

import com.JournalApp.journalApp.api.response.QuoteResponse;
import com.JournalApp.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuoteService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

//    @Value("${api.URI}")
//    private String api;
    public List getQuote(){
        System.out.println("Hello");

        ResponseEntity<List<QuoteResponse>> res;
        String api=appCache.APP_CACHE.get("quote_api");
        res = restTemplate.exchange(api, HttpMethod.GET,null,  new ParameterizedTypeReference<List<QuoteResponse>>() {});
        System.out.println(res.getBody());
        return res.getBody();



    }
}
