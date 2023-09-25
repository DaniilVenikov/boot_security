package ru.venikov.spring.boot_security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.venikov.spring.boot_security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
