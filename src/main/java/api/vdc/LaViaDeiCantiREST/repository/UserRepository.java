package api.vdc.LaViaDeiCantiREST.repository;

import api.vdc.LaViaDeiCantiREST.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
    @Query("UPDATE user set status = 'ONLINE' where tbl_user.username = ?1")
    public void setUserOnline(String username);

}
