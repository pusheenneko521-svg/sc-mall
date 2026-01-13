package org.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mall.dao.ProductMapper;
import org.mall.model.entity.Product;
import org.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> productmenu(String name) {
        if (!StringUtils.hasText(name)) {
            return  new ArrayList<>(Collections.emptyList());
        }

        return productMapper.productmenu(name);
    }
   public PageInfo<Product> productMenuByPage(String name, Integer pageNum, Integer pageSize){
       List<Product> products = productMapper.productmenu(name);
       if (!StringUtils.hasText(name)) {
           return new PageInfo<>(Collections.emptyList());
       }
       if (pageNum == null || pageNum <= 0) {
           pageNum = 1;  // 默认第一页
       }
       if (pageSize == null || pageSize <= 0) {
           pageSize = 10;  // 默认每页10条
       }
       PageHelper.startPage(pageNum, pageSize);
       return new PageInfo<>(products);


   }


}
