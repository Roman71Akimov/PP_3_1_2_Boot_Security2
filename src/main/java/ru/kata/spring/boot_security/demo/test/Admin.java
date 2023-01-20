package ru.kata.spring.boot_security.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UsersService;

import javax.annotation.PostConstruct;
import java.util.Set;
@Component
public class Admin {

    private final RoleService roleService;
    private final UsersService usersService;

    @Autowired
    public Admin(RoleService roleService, UsersService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @PostConstruct
    public void initialization() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.saveRole(roleAdmin);

        User admin = new User("admin", "admin", "admin", "admin",
                "admin@gmail.com", Set.of(roleAdmin));
        usersService.saveUser(admin);

    }
}
