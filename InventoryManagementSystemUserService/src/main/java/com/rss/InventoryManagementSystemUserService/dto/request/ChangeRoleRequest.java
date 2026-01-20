package com.rss.InventoryManagementSystemUserService.dto.request;

import com.rss.InventoryManagementSystemUserService.Enum.Role;

public record ChangeRoleRequest(
        Role role
) {
}
