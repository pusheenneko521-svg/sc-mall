package org.mall.controller;
import org.mall.service.AuthAccService;
import org.mall.model.dto.*;
import org.mall.service.RoleService;
import org.mall.service.UserRolesService;
import org.mall.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequestMapping("/admin")
@RestController
@EnableCaching
public class AuthController {
    @Autowired
    private AuthAccService authAccService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private MenuService menuService;
    @PostMapping("/login")
    public CommonResponse  login( @RequestBody AuthAccModel authAccModel){
        CommonResponse cs =  new CommonResponse();
        try {
            boolean success = authAccService.login(authAccModel.getUsername(), authAccModel.getPassword());
            if (success) {
                LgoinResponse logdata = new LgoinResponse();
                String uuid = UUID.randomUUID().toString();
                //String token = uuid;
                logdata.setTokenHead("Bearer");
                logdata.setToken(uuid);
                redisTemplate.opsForValue().set("Bearer" + uuid, authAccModel.getUsername());


                cs.setData(logdata);
                cs.setCode(200);
            } else {
                cs.setCode(404);
            }
            return cs;

            //if (authAccService.login(authAccModel.getUsername(),authAccModel.getPassword())){
            /// result.put("code",200);
            /// result.put( "message","登录成功");
            ///result.put("data",authAccModel);
            //}
            // else{
            //   result.put("code",404);
            //   result.put( "message","登录失败");
            // }
            //   return result;
        } finally {

        }
    }

    @GetMapping("/info")
    public CommonResponse getInfo(){
        CommonResponse response = new CommonResponse();
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer")) {
                response.setCode(401);
                return response;
            }

            String username = (String) redisTemplate.opsForValue().get(authHeader);
            if (username == null) {
                response.setCode(401);
                return response;
            }
            List<UserRoles> userRolesList = userRolesService.getUserRoles(username);
            if(userRolesList == null || userRolesList.size() == 0){
                response.setCode(403);

                return response;
            }
            List<String> roles = new ArrayList<>();
            for(UserRoles userRoles: userRolesList){
                roles.add(userRoles.getRolecode());
            }
            List<MenuDTOl> menus = menuService.getMenu(username);
            InfoResponse infoData = new InfoResponse();
            infoData.setUsername(username);
            infoData.setRoles(roles);
            response.setData(infoData);
            infoData.setMenus(menus);
            response.setCode(200);


        } catch (Exception e){
            response.setCode(500);
        }
        return response;





    }

}
