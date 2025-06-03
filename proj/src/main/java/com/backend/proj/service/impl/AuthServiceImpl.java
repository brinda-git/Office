package com.backend.proj.service.impl;

import com.backend.proj.dto.AuthResponse;
import com.backend.proj.model.Employee;
import com.backend.proj.dto.EmployeeLogin;
import com.backend.proj.dto.EmployeeRegister;
import com.backend.proj.repository.UserRepository;
import com.backend.proj.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(EmployeeRegister request) {
        Optional<Employee> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            return new AuthResponse("Email already exists");
        }

        Employee user = new Employee();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return new AuthResponse("User registered successfully");
    }

    @Override
    public AuthResponse login(EmployeeLogin request) {
        Optional<Employee> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            return new AuthResponse("Invalid email or password");
        }

        Employee user = userOpt.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid email or password");
        }

        return new AuthResponse("Login successful");
    }
}
