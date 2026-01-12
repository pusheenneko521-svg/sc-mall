package org.mall.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;
    private String pic;
    private String name;
    private String brandName;
    private BigDecimal price;
    private String productSn;
    private String publishStatus;
    private String newStatus;
    private String sort;
    private String recommendStatus;
    private BigDecimal sale;
    private String verifyStatus;
}
