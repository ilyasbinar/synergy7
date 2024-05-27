package com.example.xx2.controller;

import com.example.xx2.payload.JwtResponse;
import com.example.xx2.payload.LoginRequestDto;
import com.example.xx2.security.jwt.JwtUtils;
import com.example.xx2.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<Map<String, Object>>  authenticate(@RequestBody LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        JwtResponse jwtResponse = new JwtResponse(jwt, userDetails.getUsername(), roles);
        data.put("jwt", jwtResponse);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/oauth2/success")
    public ResponseEntity<Map<String, Object>> googleLoginSuccess(Authentication authentication) {
        // Create a new Principal object with modified authorities
        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
        Collection<GrantedAuthority> authorities = new ArrayList<>(oidcUser.getAuthorities());
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // TODO: fix it. Get it from DB

        UserDetailsImpl modifiedUserDetails = UserDetailsImpl.build(oidcUser);
        OidcUser modifiedOidcUser = new DefaultOidcUser(authorities, oidcUser.getIdToken(), oidcUser.getUserInfo());

        // Create a new Authentication object with the modified Principal
        Authentication modifiedAuthentication = new UsernamePasswordAuthenticationToken(
                modifiedOidcUser,
                oidcUser.getIdToken(),
                authorities
        );

        // Generate token using the modified authentication
        String jwt = jwtUtils.generateToken(modifiedAuthentication);

        // Extract user details from the modified authentication
        List<String> roles = modifiedAuthentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        Map<String, Object> data = new HashMap<>();
        JwtResponse jwtResponse = new JwtResponse(jwt, modifiedUserDetails.getUsername(), roles);
        data.put("jwt", jwtResponse);
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
