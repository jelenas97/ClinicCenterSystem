package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.security.TokenUtils;
import com.clinicCenter.security.auth.JwtAuthenticationRequest;
import com.clinicCenter.service.AuthorityService;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.UserService;
import com.clinicCenter.service.implementation.CustomUserDetailsService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/auth/medicalStaffProfile/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping(value = "/auth/check-for-change-password")
    public ResponseEntity<?> changePass(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        User user = userService.getByEmail(authenticationRequest.getUsername());
        if(user == null) {
            return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(new UserTokenState(user.getPasswordChanged()));
    }

    @PostMapping(value = "/auth/change-password")
    public void changePassword(@RequestBody String[] data) {
        String newPass = data[1];
        String email = data[3];
        User user = userService.getByEmail(email);
        user.setPassword(passwordEncoder.encode(newPass));
        user.setPasswordChanged(true);
        userService.changePassword(user.getId());
    }


    @PutMapping("/medicalStaffProfile")
    public int updateMedicalStaff(@RequestBody UserMapper user) {
        return userService.updateUser(user);
    }

    @PutMapping("/auth/activateUser/{id}")
    public void activateUser(@PathVariable Long id) {
        userService.activateUser(id);
    }

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
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, ((Authority) user.getAuthorities().iterator().next()).getName(), user.getPasswordChanged()));
    }

    @RequestMapping(value = "/api/whoami", method = RequestMethod.GET)
    public User user(Principal user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = (User) auth.getPrincipal();
        return this.userService.getByEmail(user1.getEmail());
    }

    @GetMapping("auth/getDoctors")
    public ArrayList<User> getDoctors() {
        System.out.println("daj mi doktore");
        return this.userService.getDoctors();
    }

    @GetMapping("/auth/getDoctorsFromClinic/{id}")
    public ArrayList<User> getDoctorsFromClinic(@PathVariable Long id) {
        return this.userService.getDoctorsFromClinic(id);
    }

    @DeleteMapping("/auth/removeDoctor/{id}")
    public void removeDoctor(@PathVariable Long id) {
        userService.removeDoctor(id);
    }

    @PutMapping("auth/rateDoctor/{examId}/{number}/{doctorId}")
    public void rateDoctor(@PathVariable Long examId, @PathVariable Integer number, @PathVariable Long doctorId) {
        userService.rateDoctor(doctorId, number);
        medicalExaminationService.rateDoctor(examId);
    }

    @GetMapping("auth/getSearchedDoctors/{selectedOption}/{id}")
    public Collection<User> getSearchedDoctors(@PathVariable Long selectedOption, @PathVariable Long id) {
        return userService.getSearchedDoctors(selectedOption, id);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("getAvailableDoctorsFromClinic/{adminId}")
    public Collection<User> getAvailableDoctors(@PathVariable Long adminId) {
        return userService.getDoctorsFromClinic(adminId);
    }
}
