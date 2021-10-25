package com.acme.techinterview.service;

import com.acme.techinterview.model.User;
import com.acme.techinterview.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findUser(String uid) {
    return userRepository.getUserByUid(uid);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String uid) {
    User user = this.findUser(uid);
    if (null != user) {
      userRepository.delete(user);
    }
  }
}
