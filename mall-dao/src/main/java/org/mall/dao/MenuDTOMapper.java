package org.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mall.model.dto.MenuDTO;

import java.util.List;

@Mapper
public interface MenuDTOMapper {
   List<MenuDTO> menuByACC(String name);
}
