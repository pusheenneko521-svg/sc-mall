package org.mall.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoResponse extends BaseApiResponse{
    private String username;
    private String  icon ;
    private List<String> roles;
    private List<MenuDTOl> menus;

}
