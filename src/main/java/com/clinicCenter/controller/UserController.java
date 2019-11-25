package com.clinicCenter.controller;

import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.model.UserTokenState;
import com.clinicCenter.security.TokenUtils;
import com.clinicCenter.security.auth.JwtAuthenticationRequest;
import com.clinicCenter.service.UserService;
import com.clinicCenter.service.implementation.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping(value = "/medicalStaffProfile/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/medicalStaffProfile/{id}")
    public int updateMedicalStaff(@PathVariable Long id, @RequestBody UserMapper user) {
        return userService.updateMedicalStaff(id, user);
    }
    /*
    @PostMapping("/auth/login")
    public void getUser(@RequestBody UserMapper user){
        System.out.println("loginovo sam se");

        //userService.getByEmail(user.getEmail());
    }*/
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                       HttpServletResponse response) throws AuthenticationException, IOException {

        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        System.out.println("Radiiiii");
        // Ubaci username + password u kontext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesno autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }
}
