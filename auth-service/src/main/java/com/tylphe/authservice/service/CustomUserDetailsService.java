package com.tylphe.authservice.service;

import com.tylphe.authservice.config.CustomUserDetails;
import com.tylphe.authservice.entity.UserCredential;
import com.tylphe.authservice.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserCredentialRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = repository.findByUsername(username);
        // Not working from video
//        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.orElseThrow();
    }
}
