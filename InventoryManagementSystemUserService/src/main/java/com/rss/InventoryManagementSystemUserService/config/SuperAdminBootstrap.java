package com.rss.InventoryManagementSystemUserService.config;

import com.rss.InventoryManagementSystemUserService.Enum.Role;
import com.rss.InventoryManagementSystemUserService.Enum.UserStatus;
import com.rss.InventoryManagementSystemUserService.entity.Credentials;
import com.rss.InventoryManagementSystemUserService.entity.User;
import com.rss.InventoryManagementSystemUserService.repository.CredentialsRepository;
import com.rss.InventoryManagementSystemUserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SuperAdminBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${bootstrap.super-admin.email}")
    private String email;

    @Value("${bootstrap.super-admin.password}")
    private String password;

    @Override
    public void run(String... args) {

        boolean exists = userRepository.findAll()
                .stream()
                .anyMatch(user -> user.getRole() == Role.SUPER_ADMIN);

        if (exists) {
            return;
        }

        User superAdmin = User.builder()
                .email(email)
                .role(Role.SUPER_ADMIN)
                .status(UserStatus.APPROVED)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(superAdmin);

        Credentials credentials = Credentials.builder()
                .user(superAdmin)
                .passwordHash(passwordEncoder.encode(password))
                .accountLocked(false)
                .failedLoginAttempts(0)
                .lastPasswordChange(LocalDateTime.now())
                .build();

        credentialsRepository.save(credentials);

        System.out.println("✅ Super Admin created successfully");
    }
}
