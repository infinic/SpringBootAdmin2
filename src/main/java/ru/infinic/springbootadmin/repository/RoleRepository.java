package ru.infinic.springbootadmin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.infinic.springbootadmin.model.Role;

/**
 * @author Oleg Kadochnikov
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
