package com.acme.techinterview.controller;

import com.acme.techinterview.model.User;
import com.acme.techinterview.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;
//    @Autowired
//    private UserRepository userRepository;


  @Operation(summary = "Find all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "return all users or empty list",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = User[].class))})
  })
  @GetMapping
  public Iterable<User> getUsers() {
    return userService.findAll();
  }

  @Operation(summary = "Find user by uid")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the user",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
      @ApiResponse(responseCode = "400", description = "Invalid uid supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content)})
  @GetMapping("/{userid}")
  @ResponseStatus(HttpStatus.OK)
  public User getUser(
      @Parameter(description = "uid of user to be searched") @PathVariable String userid) {
    return userService.findUser(userid);
  }

  @Operation(summary = "Create user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User created",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
      @ApiResponse(responseCode = "400", description = "User's info invalid ", content = @Content)})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User saveUsers(@NotNull @Valid @RequestBody User user) {
    return userService.createUser(user);
  }

  @Operation(summary = "Delete user by uid")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "User deleted",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
      @ApiResponse(responseCode = "400", description = "Invalid uid supplied", content = @Content),
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content)})
  @DeleteMapping("/{uid}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUser(
      @Parameter(description = "uid of user to be deleted") @PathVariable String uid) {
    userService.deleteUser(uid);
  }
}
