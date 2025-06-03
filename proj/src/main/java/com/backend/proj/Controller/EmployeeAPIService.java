package com.backend.proj.Controller;


import com.backend.proj.dto.AuthResponse;
import com.backend.proj.model.Employee;
import com.backend.proj.dto.EmployeeLogin;
import com.backend.proj.dto.EmployeeRegister;
import com.backend.proj.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api/auth")

public class EmployeeAPIService {

    @Autowired
    private AuthService authService;

     @GetMapping("/h")
     public String hello()
     {
    return "hello this is a new page";
    }

    @GetMapping("/register")
    public Employee register(int id) {
        return new Employee(1,"user1","gyh@gmail.com","der","der");
    }
    @PostMapping("/register")
    public AuthResponse register(@RequestBody EmployeeRegister request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody EmployeeLogin request) {
        return authService.login(request);
    }



}
