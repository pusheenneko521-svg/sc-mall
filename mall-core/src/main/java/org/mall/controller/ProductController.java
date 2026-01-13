package org.mall.controller;

import com.github.pagehelper.PageInfo;
import org.mall.dao.ProductMapper;
import org.mall.model.dto.CommonResponse;
import org.mall.model.entity.Product;
import org.mall.model.entity.ProductDTO;
import org.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @GetMapping("/list")
    public  CommonResponse getProductList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize ){
        ProductDTO productDTO = new ProductDTO();
        CommonResponse cs = new CommonResponse();

        try{
            if(pageNum == null || pageNum <=0){
                pageNum = 1;
            }
            if (pageSize == null || pageSize <=0){
                pageSize = 10;
            }
            productDTO.setList(productMapper.productmenu("奶"));
            PageInfo<Product> page = productService.productMenuByPage("奶", pageNum, pageSize);
            long total = page.getTotal();
            productDTO.setTotal(total);
            cs.setCode(200);
            cs.setData(productDTO);
            productDTO.setList(page.getList());
        } catch (Exception e){
            e.printStackTrace();
            productDTO.setList(Collections.emptyList());
        }
        return cs;
    }







}
