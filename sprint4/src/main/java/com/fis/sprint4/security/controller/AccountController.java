package com.fis.sprint4.security.controller;

import com.fis.sprint4.model.Person;
import com.fis.sprint4.security.model.Role;
import com.fis.sprint4.security.model.UserRole;
import com.fis.sprint4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private PersonService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Person createUser(@RequestBody Person user) throws Exception {
        user.setCreateAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        user.setHiringDate(LocalDateTime.now());
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roleSet = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1L);
        role.setRoleName("TRAINEE");
        UserRole userRole = new UserRole();
        userRole.setPerson(user);
        userRole.setRole(role);
        roleSet.add(userRole);
        return this.userService.createUser(user, roleSet);
    }

}
