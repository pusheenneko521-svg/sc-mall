package org.mall.service.impl;

import org.mall.model.dto.MenuDTO;
import org.mall.model.dto.MenuDTOl;
import org.mall.service.MenuService;
import org.springframework.stereotype.Service;
import org.mall.dao.MenuDTOMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDTOMapper menuDTOMapper;

    @Override
    public List<MenuDTOl> getMenu(String name) {
        List<MenuDTOl> menuDTOList = new ArrayList<>();
        List<MenuDTO> mdto = menuDTOMapper.menuByACC(name);
        if (mdto != null) {
            for (MenuDTO menuDTO : mdto) {
                MenuDTOl menuDTOl = new MenuDTOl();
                menuDTOl.setId(menuDTO.getId());
                menuDTOl.setTitle(menuDTO.getTitle());
                menuDTOl.setLevel(menuDTO.getLevel());
                menuDTOl.setName(menuDTO.getName());
                menuDTOl.setIcon(menuDTO.getIcon());
                menuDTOl.setHidden(menuDTO.getHidden() == 0 ? false : true);
                menuDTOl.setParentId(menuDTO.getParentId());
                menuDTOList.add(menuDTOl);

            }
            return menuDTOList;
        }
        return menuDTOList;


    }


}
