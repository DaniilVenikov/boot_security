package ru.venikov.spring.boot_security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.venikov.spring.boot_security.models.User;
import ru.venikov.spring.boot_security.services.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userService.checkUsersName(user.getName()).isEmpty()) {
            return;
        }

        errors.rejectValue("name", "", "Человек с таким именем уже существует");
    }
}
