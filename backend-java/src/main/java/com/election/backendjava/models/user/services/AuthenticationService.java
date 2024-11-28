package com.election.backendjava.models.user.services;

import com.election.backendjava.entities.Role;
import com.election.backendjava.entities.User;
import com.election.backendjava.models.user.dto.LoginUserDto;
import com.election.backendjava.models.user.dto.RegisterUserDto;
import com.election.backendjava.models.user.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserDto input) {
        User user = new User();
        user.setUserName(input.getUsername());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setEmail(input.getEmail());
        user.setRole(new Role(Role.USER_ROLE_ID));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto loginUserDto) {
        User user = userRepository.findByUsername(loginUserDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(loginUserDto.getUsername()));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUserDto.getUsername(),
                loginUserDto.getPassword()
        ));

        return user;
    }
}
