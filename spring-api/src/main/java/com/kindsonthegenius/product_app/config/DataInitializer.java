package com.kindsonthegenius.product_app.config;

import com.kindsonthegenius.product_app.model.User;
import com.kindsonthegenius.product_app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setFirstname("Admin");
                admin.setLastname("User");
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                userRepository.save(admin);
            }

            if (userRepository.findByUsername("user") == null) {
                User user = new User();
                user.setFirstname("Standard");
                user.setLastname("User");
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                userRepository.save(user);
            }
        };
    }
}


