package org.mall.service.impl;

import com.github.pagehelper.util.StringUtil;
import org.mall.dao.ProductMapper;
import org.mall.model.dto.Product;
import org.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> productmenu(String name) {
        if (!StringUtils.hasText(name)) {
            return Collections.emptyList();
        }

        return productMapper.productmenu(name);

    }


}
