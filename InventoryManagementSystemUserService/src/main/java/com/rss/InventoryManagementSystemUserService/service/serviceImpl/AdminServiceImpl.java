package com.rss.InventoryManagementSystemUserService.service.serviceImpl;

import com.rss.InventoryManagementSystemUserService.Enum.Role;
import com.rss.InventoryManagementSystemUserService.Enum.UserStatus;
import com.rss.InventoryManagementSystemUserService.dto.response.AdminUserResponse;
import com.rss.InventoryManagementSystemUserService.entity.User;
import com.rss.InventoryManagementSystemUserService.repository.UserRepository;
import com.rss.InventoryManagementSystemUserService.service.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public List<AdminUserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new AdminUserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getRole().name(),
                        user.getStatus() == UserStatus.APPROVED,
                        user.getStatus() == UserStatus.SUSPENDED
                ))
                .toList();
    }

    @Override
    public void approveUser(Long userId) {
        User user = getUser(userId);

        if (user.getStatus() == UserStatus.SUSPENDED) {
            throw new IllegalStateException("Suspended users must be activated first");
        }

        user.setStatus(UserStatus.APPROVED);
    }

    @Override
    public void suspendUser(Long userId) {
        User user = getUser(userId);
        user.setStatus(UserStatus.SUSPENDED);
    }

    @Override
    public void activateUser(Long userId) {
        User user = getUser(userId);

        if (user.getStatus() != UserStatus.SUSPENDED) {
            throw new IllegalStateException("Only suspended users can be activated");
        }

        user.setStatus(UserStatus.APPROVED);
    }

    @Override
    public void changeRole(Long userId, Role role) {
        User user = getUser(userId);

        if (user.getStatus() == UserStatus.SUSPENDED) {
            throw new IllegalStateException("Cannot change role of suspended user");
        }

        user.setRole(role);
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userId));
    }
}
