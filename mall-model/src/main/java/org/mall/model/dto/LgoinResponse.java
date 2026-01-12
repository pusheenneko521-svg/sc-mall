package org.mall.model.dto;

import lombok.Data;

@Data
public class LgoinResponse extends BaseApiResponse{
    //登录返回子类
    private String token;
    private String tokenHead;

}
