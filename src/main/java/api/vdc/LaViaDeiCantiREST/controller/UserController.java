package api.vdc.LaViaDeiCantiREST.controller;

import api.vdc.LaViaDeiCantiREST.model.User;
import api.vdc.LaViaDeiCantiREST.service.UserService;
import api.vdc.LaViaDeiCantiREST.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    /**
     * Constructor of UserController class.
     * @param userService autowired from Spring
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * This method take in input an user passed by POST Method in Json.
     * @param user the user that will be saved in DB
     */
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    /**
     * Validate the user password and return the user logged.
     * @param user who needs to be validated
     * @return user or null if error
     */
    @PostMapping("/validateUser")
    public User validateUser(@RequestBody User user) {
      return userService.validateUser(user);
    }
    /**
     * Logout of user
     * @param username of the user
     */
    @GetMapping("/logoutUser/{username}")
    public void logoutUser(@PathVariable String username){
        userService.logoutUser(username);
    }
}
