package com.rss.InventoryManagementSystemUserService.dto.response;

public record AdminUserResponse(
        Long id,
        String email,
        String role,
        boolean enabled,
        boolean suspended
) {
}
