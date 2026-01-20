package com.rss.InventoryManagementSystemUserService.service;

import com.rss.InventoryManagementSystemUserService.Enum.Role;
import com.rss.InventoryManagementSystemUserService.dto.response.AdminUserResponse;

import java.util.List;

public interface AdminService {

    List<AdminUserResponse> getAllUsers();
    void approveUser(Long userId);
    void suspendUser(Long userId);
    void activateUser(Long userId);
    void changeRole(Long userId, Role role);
}
