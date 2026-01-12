package org.mall.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private BaseApiResponse  data;
    private  Integer  code =200;


}
