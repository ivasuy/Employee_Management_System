package com.intern.emp_sys.controller;

import com.intern.emp_sys.model.User;
import com.intern.emp_sys.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/token")
    public String getToken(@RequestBody User user) throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        if(userDetails.getPassword().equals(user.getPassword())){
            return jwtProvider.generateToken(user.getUsername());
        }

        throw new Exception("Invalid username or password");
    }
}
