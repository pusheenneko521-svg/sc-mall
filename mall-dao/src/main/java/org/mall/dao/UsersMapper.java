package org.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mall.model.dto.AuthAccModel;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {
   AuthAccModel selectByACC(@Param("username") String username);
}
