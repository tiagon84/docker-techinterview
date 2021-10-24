package com.acme.techinterview.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.acme.techinterview.model.User;
import com.acme.techinterview.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


  @InjectMocks
  UserService userService;

  @Mock
  UserRepository userRepository;

  private List<User> users;

  @Before
  public void init() {
    users = Arrays.asList(
        new User("marsh", "Stan", "Marsh"),
        new User("cartman", "Eric", "Cartman"),
        new User("mccormick", "Kenny", "McCormick"),
        new User("broflovski", "Kyle", "Broflovski"),
        new User("stotch", "Butters", "Stotch")
    );
    when(userRepository.findAll()).thenReturn(users);
  }

  @Test
  public void getUsers() {

    List<User> all = userService.findAll();

    assertEquals(all.isEmpty(), false);
    assertEquals(all.size(), 5);
  }


  @Test
  public void getUser() {
    String uid = "marsh";

    User u1 = users.stream().filter(u -> u.getUid().equalsIgnoreCase(uid)).findFirst().get();
    when(userRepository.getUserByUid(anyString())).thenReturn(u1);

    User user = userService.findUser(uid);

    assertNotEquals(user, null);
    assertEquals(uid, user.getUid());
  }

  @Test
  public void createUser() {
    String uid = "chef";
    String firstName = "Chef";
    String lastName = "";

    User u = new User(uid, firstName, lastName);
    when(userRepository.save(any(User.class))).thenReturn(u);

    User user = userService.createUser(u);

    assertNotEquals(user, null);
    assertEquals(uid, user.getUid());
    assertEquals(firstName, user.getFirstName());
    assertEquals(lastName, user.getLastName());
  }


  @Test
  public void deleteUser() {
    String uid = "cartman";

    User u1 = users.stream().filter(u -> u.getUid().equalsIgnoreCase(uid)).findFirst().get();
    when(userRepository.getUserByUid(anyString())).thenReturn(u1);

    userService.deleteUser(uid);

    verify(userRepository, times(1)).delete(any(User.class));
  }


}