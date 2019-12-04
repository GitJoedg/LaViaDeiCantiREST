package api.vdc.LaViaDeiCantiREST.service;

import api.vdc.LaViaDeiCantiREST.model.User;
import org.springframework.web.bind.annotation.RequestBody;


public interface UserService {
    User validateUser(User user);
    String saveUser(User user);
    void logoutUser(String username);
}
