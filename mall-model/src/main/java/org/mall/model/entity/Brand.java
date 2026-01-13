package org.mall.model.entity;

import lombok.Data;

@Data
public class Brand {
    private Integer id;
    private String name;
    private Character firstLetter;
    private Integer sort;
    private Boolean factoryStatus;
    private Long createdAt;
    private Long updatedAt;
}
