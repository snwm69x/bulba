package com.sneg.likevavo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.Role;
import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder  passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setId(2L); // or "ADMIN" depending on the user's role
        user.setRole(role);
        userRepository.save(user);
    }
}
    

