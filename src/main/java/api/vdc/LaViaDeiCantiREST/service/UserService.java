package api.vdc.LaViaDeiCantiREST.service;

import api.vdc.LaViaDeiCantiREST.model.User;
import api.vdc.LaViaDeiCantiREST.repository.UserRepository;
import api.vdc.LaViaDeiCantiREST.utils.PasswordManager;
import api.vdc.LaViaDeiCantiREST.utils.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor of UserService class.
     * @param userRepository autowired from Spring
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * This method take in input an user passed by POST Method in Json.
     * Then, encrypt his password with salt and hash technique and save into DB
     * @param user the user that will be saved in DB
     */
    public String saveUser(@RequestBody User user){
        byte [] salt = PasswordManager.getNextSalt(); //PasswordManager.getNextSalt();
        System.out.println(user.getPassword().toCharArray());
        byte[] hash = PasswordManager.hash(user.getPassword().toCharArray(), salt);
        user.setSalt(salt);
        user.setHash(hash);
        userRepository.save(user);
        userRepository.setUserStatus("OFFLINE", user.getUsername());
        return "{}";
    }
    /**
     * This method validate the User passed in input by retrieving his salt and hash from DB,
     * hashing password from input and comparing with hash from DB.
     * @param user who needs to be validated
     * @return user or null if compare fails.
     */
    public User validateUser(@RequestBody User user) {
        String username = user.getUsername();
        Optional<User> userDAO = userRepository.findById(username);
        if (userDAO.isPresent()) {
            byte[] hash = PasswordManager.hash(user.getPassword().toCharArray(), userDAO.get().getSalt());
            if(Arrays.equals(hash, userDAO.get().getHash())){
                userRepository.setUserStatus(UserStatus.ONLINE.toString(), username);
                User result = userDAO.get();
                result.setUserStatus(UserStatus.ONLINE);
                return result;
            }
        }
        return null;
    }

    /**
     * Set the user to an OFFLINE status
     * @param username of the user
     */
    public void logoutUser(String username){
        userRepository.setUserStatus(UserStatus.OFFLINE.toString(), username);
    }
}
