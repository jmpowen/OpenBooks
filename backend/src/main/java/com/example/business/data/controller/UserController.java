package com.example.business.data.controller;

import com.example.business.data.entities.User;
import com.example.business.data.services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/user")
@OpenAPIDefinition()
public class UserController {

    @Autowired
    UserService userService;

    /**
     * get a specific user
     * @param user_email
     * @return specific user
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{user_email}")
    @ResponseBody
    @Operation(summary = "Get User by user email",
            responses = {
                    @ApiResponse(description = "The user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "400", description = "User not found")})
    public Optional<User> getUserByUserEmail(
            @Parameter(description = "The id that needs to be fetched. Use user1 for testing. ", required = true)
            @PathVariable String user_email){
        return userService.getEntityByID(user_email);
    }

    /**
     * get all users as optional
     * @return optional<users>
     */
    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllEntities();
    }

    /**
     *
     * @param newUser
     * @return response entity
     */
    @RequestMapping(method = RequestMethod.POST, path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return userService.createEntity(newUser, newUser.getUser_email());
    }

    /**
     * Deletes the user given their unique id
     * @param user_email
     * @return response entity
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{user_email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  deleteUser(@PathVariable String user_email) {
        return userService.deleteEntityById(user_email);
    }

    /**
     * @param user_email
     * @return a json object response
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/edit/{user_email}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  editUser(@RequestBody User newUserInfo, @PathVariable String user_email) {
        return userService.editEntity(newUserInfo, user_email);
    }

}