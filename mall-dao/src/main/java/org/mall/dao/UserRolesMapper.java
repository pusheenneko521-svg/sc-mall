package org.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mall.model.dto.UserRoles;
@Mapper
public interface UserRolesMapper {
    UserRoles  dto1(String  username);
}
