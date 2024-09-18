package com.kakuritsu.security.auth;

import com.kakuritsu.security.user.User;
import com.kakuritsu.security.user.UserRepository;
import com.kakuritsu.security.user.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
   private final UserRepository userRepository;
   private final JwtService jwtService;
   private final PasswordEncoder passwordEncoder;
   private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){

        var user = User.builder()
                   .firstname(request.getFirstname())
                   .lastname(request.getLastname())
                   .email(request.getEmail())
                   .password(passwordEncoder.encode(request.getPassword()))
                   .build();
      userRepository.save(user);
      var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
