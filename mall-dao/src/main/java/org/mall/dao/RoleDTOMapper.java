package org.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mall.model.dto.RoleDTO;
@Mapper
public interface RoleDTOMapper {
    RoleDTO gl(@Param("id") Integer id);
}
