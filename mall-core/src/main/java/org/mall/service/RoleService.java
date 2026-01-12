package org.mall.service;

import org.apache.ibatis.annotations.Param;
import org.mall.model.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getUserRoleDetails(Integer id);
}
