package com.clinicCenter.controller;

import com.clinicCenter.model.Authority;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

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

    @GetMapping(value = "/auth/medicalStaffProfile/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/medicalStaffProfile/{id}")
    public int updateMedicalStaff(@PathVariable Long id, @RequestBody UserMapper user) {
        return userService.updateMedicalStaff(id, user);
    }

    @PutMapping("/auth/activateUser/{id}")
    public void activateUser(@PathVariable Long id) {
        System.out.println("aktiviran");
        userService.activateUser(id);
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
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci username + password u kontext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token
        User user = (User) authentication.getPrincipal();
        Authority a = (Authority) user.getAuthorities().iterator().next();
        String jwt = tokenUtils.generateToken(user.getEmail(), a);
        int expiresIn = tokenUtils.getExpiredIn();
        System.out.println("Radiiiii");

        // Vrati token kao odgovor na uspesno autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, ((Authority) user.getAuthorities().iterator().next()).getName()));
    }

    @RequestMapping(value = "/api/whoami", method = RequestMethod.GET)
    public User user(Principal user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = (User) auth.getPrincipal();
        return this.userService.getByEmail(user1.getEmail());
    }
}
