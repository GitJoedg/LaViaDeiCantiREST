package api.vdc.LaViaDeiCantiREST.repository;

import api.vdc.LaViaDeiCantiREST.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD Repository for User model.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
