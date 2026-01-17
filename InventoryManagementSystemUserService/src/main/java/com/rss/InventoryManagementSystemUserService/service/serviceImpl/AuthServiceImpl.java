package com.rss.InventoryManagementSystemUserService.service.serviceImpl;


import com.rss.InventoryManagementSystemUserService.Enum.UserStatus;
import com.rss.InventoryManagementSystemUserService.dto.request.LoginRequest;
import com.rss.InventoryManagementSystemUserService.dto.response.LoginResponse;
import com.rss.InventoryManagementSystemUserService.entity.Credentials;
import com.rss.InventoryManagementSystemUserService.entity.User;
import com.rss.InventoryManagementSystemUserService.repository.CredentialsRepository;
import com.rss.InventoryManagementSystemUserService.repository.UserRepository;
import com.rss.InventoryManagementSystemUserService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (user.getStatus() != UserStatus.APPROVED) {
            throw new RuntimeException("User is not approved");
        }

        Credentials credentials = credentialsRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Credentials not found"));

        if (!passwordEncoder.matches(request.getPassword(), credentials.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtProvider.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .role(user.getRole().name())
                .build();
    }
}
