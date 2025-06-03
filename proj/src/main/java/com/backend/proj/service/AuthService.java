package com.backend.proj.service;

import com.backend.proj.dto.AuthResponse;
import com.backend.proj.dto.EmployeeLogin;
import com.backend.proj.dto.EmployeeRegister;

public interface AuthService {
    AuthResponse register(EmployeeRegister request);
    AuthResponse login(EmployeeLogin request);
}
