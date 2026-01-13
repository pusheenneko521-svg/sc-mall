package org.mall.dao;

import org.mall.model.entity.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> productmenu( String name);
}
