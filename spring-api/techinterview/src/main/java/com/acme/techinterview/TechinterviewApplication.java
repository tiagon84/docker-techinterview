package com.acme.techinterview;

import com.acme.techinterview.model.User;
import com.acme.techinterview.repository.UserRepository;
import com.acme.techinterview.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Log
public class TechinterviewApplication {

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(TechinterviewApplication.class, args);
    }


    @Bean
    ApplicationRunner init() {
        return args -> {
            log.info("Checking LDAP for initial Users");

            List<User> users = userRepository.findAll();
            if (null == users || users.isEmpty()) {
                log.info("LDAP is empty! Populating with South Park characters");

                userRepository.saveAll(Arrays.asList(
                        new User("marsh", "Stan", "Marsh"),
                        new User("cartman", "Eric", "Cartman"),
                        new User("mccormick", "Kenny", "McCormick"),
                        new User("broflovski", "Kyle", "Broflovski"),
                        new User("stotch", "Butters", "Stotch")
                ));
            }
            log.info("LDAP is populated!");
        };
    }


}
