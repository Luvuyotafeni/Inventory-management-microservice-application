package com.rss.InventoryManagementSystemUserService.service.serviceImpl;

import com.rss.InventoryManagementSystemUserService.Enum.Role;
import com.rss.InventoryManagementSystemUserService.Enum.UserStatus;
import com.rss.InventoryManagementSystemUserService.dto.response.AdminUserResponse;
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

    }

    @Override
    public void suspendUser(Long userId) {

    }

    @Override
    public void activateUser(Long userId) {

    }

    @Override
    public void changeRole(Long userId, Role role) {

    }
}
