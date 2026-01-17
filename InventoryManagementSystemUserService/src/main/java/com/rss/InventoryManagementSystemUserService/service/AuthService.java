package com.rss.InventoryManagementSystemUserService.service;

import com.rss.InventoryManagementSystemUserService.dto.request.LoginRequest;
import com.rss.InventoryManagementSystemUserService.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}
