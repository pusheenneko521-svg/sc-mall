package org.mall.model.entity;

import lombok.Data;

@Data
public class MenuDTOl {
    private Integer id;
    private String title;
    private Integer level;
    private String name;
    private String icon;
    private boolean hidden;
    private Integer parentId;
}
