package com.campuslands.Mi_Red_Social.auth;

import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.jwt.JwtService;
import com.campuslands.Mi_Red_Social.repositories.UserRepository;
import com.campuslands.Mi_Red_Social.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String token = jwtService.getToken(user);

        AuthResponse authResponse = new AuthResponse();

        authResponse.setToken(token);

        return authResponse;
    }

    public AuthResponse register(RegisterRequest request){
        UserEntity user = new UserEntity();

        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone_number());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBiography(request.getBiography());
        user.setPhoto_profile(request.getPhoto_profile());
        user.setCreated_at(request.getCreated_at());
        user.setBirthday(request.getBirthday());
        user.setRol(Role.USER);

        userRepository.save(user);

        AuthResponse auth = new AuthResponse();

        auth.setToken(jwtService.getToken(user));

        return auth;
    }
}
