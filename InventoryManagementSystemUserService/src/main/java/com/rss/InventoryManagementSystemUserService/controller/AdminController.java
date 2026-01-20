package com.rss.InventoryManagementSystemUserService.controller;

import com.rss.InventoryManagementSystemUserService.dto.response.AdminUserResponse;
import com.rss.InventoryManagementSystemUserService.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN)")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public List<AdminUserResponse> getAllUsers(){
        return adminService.getAllUsers();
    }
}
