package org.mall.model.entity;

import lombok.Data;
import org.mall.model.dto.BaseApiResponse;

import java.util.List;
@Data
public class ProductDTO extends BaseApiResponse {
    private List<Product> list;
    private long total;
}
