package org.mall.service;

import com.github.pagehelper.PageInfo;
import org.mall.model.entity.Product;

import java.util.List;

public interface ProductService  {
    List<Product> productmenu(String name);
    PageInfo<Product> productMenuByPage(String name, Integer pageNum, Integer pageSize);

}
