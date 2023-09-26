package ru.venikov.spring.boot_security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.venikov.spring.boot_security.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
