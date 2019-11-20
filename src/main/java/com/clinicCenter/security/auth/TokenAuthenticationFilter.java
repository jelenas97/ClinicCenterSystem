package com.clinicCenter.security.auth;

import com.clinicCenter.security.TokenUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String email;
        String authToken = tokenUtils.getToken(request);

        if (authToken != null) {
            // uzmi username iz tokena
            email = tokenUtils.getEmailFromToken(authToken);

            if (email != null) {
                // uzmi user-a na osnovu username-a
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                // proveri da li je prosledjeni token validan
                if (tokenUtils.validateToken(authToken, userDetails)) {
                    // kreiraj autentifikaciju
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        // prosledi request dalje u sledeci filter
        chain.doFilter(request, response);
    }
}
