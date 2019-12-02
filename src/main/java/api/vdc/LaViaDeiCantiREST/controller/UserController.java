package api.vdc.LaViaDeiCantiREST.controller;

import api.vdc.LaViaDeiCantiREST.model.User;
import api.vdc.LaViaDeiCantiREST.repository.UserRepository;
import api.vdc.LaViaDeiCantiREST.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    /**
     * Constructor of UserController class.
     * @param userRepository autowired from Spring
     */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method take in input an user passed by POST Method in Json.
     * Then, encrypt his password with salt and hash technique and save into DB
     * @param user the user that will be saved in DB
     */
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user){
       byte [] salt = PasswordManager.getNextSalt(); //PasswordManager.getNextSalt();
        System.out.println(user.getPassword().toCharArray());
       byte[] hash = PasswordManager.hash(user.getPassword().toCharArray(), salt);
       user.setSalt(salt);
       user.setHash(hash);
       userRepository.save(user);
    }

    @PostMapping("/validateUser")
    public User validateUser(@RequestBody User user) {
        String username = user.getUsername();
        Optional<User> userDAO = userRepository.findById(username);
        if (userDAO.isPresent()) {
            byte[] hash = PasswordManager.hash(user.getPassword().toCharArray(), userDAO.get().getSalt());
            if(Arrays.equals(hash, userDAO.get().getHash())){
                return userDAO.get();
            }
        }
        return null;
    }
}
