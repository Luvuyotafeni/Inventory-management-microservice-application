package com.rss.InventoryManagementSystemUserService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;
    private String gender;

    @Column(unique = true)
    private String nationalIdNumber;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String country;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
