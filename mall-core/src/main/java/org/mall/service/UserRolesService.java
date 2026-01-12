package org.mall.service;

import org.mall.model.dto.UserRoles;

import java.util.List;

public interface UserRolesService {
    List<UserRoles> getUserRoles(String username);
}
