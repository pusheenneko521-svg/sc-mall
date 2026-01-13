package org.mall.service.impl;

import org.mall.dao.RoleDTOMapper;
import org.mall.model.entity.RoleDTO;
import org.mall.service.RoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServicelmpl implements RoleService {
    @Resource
    private RoleDTOMapper roleDTOMapper;

    @Override
    public List<RoleDTO> getUserRoleDetails(Integer id){
        List<RoleDTO> list = new ArrayList<>();

       RoleDTO dto1 = roleDTOMapper.gl(id);

       if(dto1 != null){
           list.add(dto1);
           return list;
       }

       return list;
    }
}
