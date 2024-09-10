package com.JournalApp.journalApp;


import com.JournalApp.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendMail(){
        System.out.println("Hello Start");
        emailService.sendEmail("laveshsaluja@gmail.com","Test Mail",
                "<b> Hello BKL </b>");
    }
}
