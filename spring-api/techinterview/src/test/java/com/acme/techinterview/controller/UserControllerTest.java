package com.acme.techinterview.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @Test
  @WithMockUser(username = "user", password = "123456")
  void getUsers() throws Exception {
    this.mockMvc.perform(get("/users")).andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "user", password = "123456")
  void getUser() throws Exception {

    this.mockMvc.perform(get("/users/cartman")).andExpect(status().isOk());
  }

}