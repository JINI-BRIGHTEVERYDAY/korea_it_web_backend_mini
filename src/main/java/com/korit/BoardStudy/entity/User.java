package com.korit.BoardStudy.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createDt;
    private LocalDate updateDt;

    private List<UserRole> userRoles;
}
