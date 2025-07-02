package com.korit.BoardStudy.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRole {
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    private Role role;
}
