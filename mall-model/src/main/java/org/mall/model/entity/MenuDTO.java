package org.mall.model.entity;

import lombok.Data;

@Data
public class MenuDTO {
    private Integer id;
    private String title;
    private Integer level;
    private String name;
    private String icon;
    private Integer hidden;
    private Integer parentId;
}
