package com.acme.techinterview.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.acme.techinterview.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @Test
  void getUsers() throws Exception {
    this.mockMvc.perform(get("/users")).andExpect(status().isOk());
  }

  //@Test
  void getUser() throws Exception {

//    this.mockMvc.perform(get("/users")).andExpect(status().isOk());
  }

  //@Test
  void saveUsers() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    User user = new User("garrison", "Mr.", "Garrison");
    this.mockMvc.perform(
            post("/users").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user)))
        .andExpect(status().isOk());
  }

  //@Test
  void deleteUser() {
//    this.mockMvc.perform(get("/users")).andExpect(status().isOk());
  }
}