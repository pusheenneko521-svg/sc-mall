package org.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mall.model.entity.UserRoles;
@Mapper
public interface UserRolesMapper {
    UserRoles  dto1(String  username);
}
