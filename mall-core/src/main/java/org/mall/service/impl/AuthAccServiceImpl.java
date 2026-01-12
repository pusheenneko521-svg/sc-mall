package org.mall.service.impl;
import org.mall.util.MD5Util;
import org.mall.dao.UsersMapper;
import org.mall.model.dto.AuthAccModel;
import org.mall.service.AuthAccService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthAccServiceImpl implements AuthAccService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public boolean
    login(String username, String password) {
        AuthAccModel authAccModel = usersMapper.selectByACC(username);
        if (authAccModel == null) {
            return false;
        }
        //加密密码
        String encryptedPassword = MD5Util.md5(password);
        //获取数据库的密码
        String dbPassword = authAccModel.getPassword();
        //比对密码
        return encryptedPassword.equals(dbPassword);
    }
}
