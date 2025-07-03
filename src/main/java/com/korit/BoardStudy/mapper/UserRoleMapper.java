package com.korit.BoardStudy.mapper;

import com.korit.BoardStudy.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    int addUserRole(UserRole userRole);
}
