package ru.infinic.springbootadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infinic.springbootadmin.model.Role;
import ru.infinic.springbootadmin.model.User;
import ru.infinic.springbootadmin.repository.RoleRepository;
import ru.infinic.springbootadmin.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Set;

/**
 * @author Oleg Kadochnikov
 */

@Service
public class DBInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    void init() {
        System.out.println("Starting Database initialization...");

        if (((Collection<?>) userRepository.findAll()).size() == 0) {
            roleRepository.save(new Role("ROLE_ADMIN", "Administrator"));
            roleRepository.save(new Role("ROLE_USER", "User"));
            userRepository.save(new User("admin", "admin", "Administrator", true, Set.of(roleRepository.findByName("ROLE_ADMIN"))));
            userRepository.save(new User("user", "user", "Simple user", true, Set.of(roleRepository.findByName("ROLE_USER"))));
        }
    }

}