package com.xy.videosback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class SearchHistory {

  private long id;

  private String content;
//  @TableField(value = "cr")
  private Date createTime;

  private long num;


}
