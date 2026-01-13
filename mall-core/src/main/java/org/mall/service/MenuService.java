package org.mall.service;

import org.mall.model.entity.MenuDTOl;

import java.util.List;

public interface MenuService {
    List<MenuDTOl> getMenu(String name);
}
