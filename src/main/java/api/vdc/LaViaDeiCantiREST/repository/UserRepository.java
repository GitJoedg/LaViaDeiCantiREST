package api.vdc.LaViaDeiCantiREST.repository;

import api.vdc.LaViaDeiCantiREST.model.User;
import api.vdc.LaViaDeiCantiREST.utils.UserStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * CRUD Repository for User model.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    /**
     *
     * Set the status of the user, online.
     * @param username of the user.
     */
    @Modifying
    @Transactional
    @Query("UPDATE User set status = ?1 where username = ?2")
    public void setUserStatus(String status, String username);

}
