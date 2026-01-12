package org.mall.service.impl;

import org.mall.dao.UserRolesMapper;
import org.mall.model.dto.UserRoles;
import org.mall.service.UserRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicelmpl implements UserRolesService {
    @Resource
    private UserRolesMapper userRolesMapper;
    @Override
    public List<UserRoles> getUserRoles(String username) {
        List<UserRoles> list1 = new ArrayList<>();
        UserRoles userRoles = userRolesMapper.dto1(username);
        if(userRoles != null){
            list1.add(userRoles);
            return list1;
        } return list1;
    }

}
