package com.rss.InventoryManagementSystemUserService.repository;

import com.rss.InventoryManagementSystemUserService.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    Optional<Credentials> findByUserId(Long userId);
}
