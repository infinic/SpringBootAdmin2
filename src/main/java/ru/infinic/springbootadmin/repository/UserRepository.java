package ru.infinic.springbootadmin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.infinic.springbootadmin.model.User;

/**
 * @author Oleg Kadochnikov
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
