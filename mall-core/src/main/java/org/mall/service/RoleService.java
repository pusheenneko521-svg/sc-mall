package org.mall.service;

import org.mall.model.entity.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getUserRoleDetails(Integer id);
}
