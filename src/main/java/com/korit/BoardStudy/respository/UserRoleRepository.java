package com.korit.BoardStudy.respository;

import com.korit.BoardStudy.entity.UserRole;
import com.korit.BoardStudy.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public int addUserRole(UserRole userRole) {
        return userRoleMapper.addUserRole(userRole);
    }
}
