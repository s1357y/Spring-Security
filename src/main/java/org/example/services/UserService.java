package org.example.services;

import lombok.AllArgsConstructor;
import org.example.exceptions.AlreadyRegisteredUserException;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User signup(String username, String password, String Role){
        if(userRepository.findByUsername(username) != null){
            throw new AlreadyRegisteredUserException();
        }
        return userRepository
                .save(new User(
                        username,
                        passwordEncoder.encode(password),
                        Role));
    }

    public User signupAdmin(String username, String password){
        if(userRepository.findByUsername(username) != null){
            throw new AlreadyRegisteredUserException();
        }
        return userRepository
                .save(new User(
                        username,
                        passwordEncoder.encode(password),
                        "ROLE_Admin"));
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
