package org.mall.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoleDTO {
  private Integer id;
  private String name;
  private String description;
  private Integer adminCount;
  private Date createTime;
  private Byte status;


}
