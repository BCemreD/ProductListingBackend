package com.cemre.product_backend.config;

import com.cemre.product_backend.model.entity.User;
import com.cemre.product_backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        User user1 = userRepository.findByUsername("Johnd")
                .orElse(User.builder()
                        .username("Johnd")
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .password(passwordEncoder.encode("12345"))
                        .role("USER")
                        .build());
        userRepository.save(user1);

        User user2 = userRepository.findByUsername("Janese")
                .orElse(User.builder()
                        .username("Janese")
                        .firstName("Jane")
                        .lastName("Seully")
                        .email("jane.seully@example.com")
                        .password(passwordEncoder.encode("11233"))
                        .role("USER")
                        .build());
        userRepository.save(user2);
    }
}
