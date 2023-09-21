package com.xy.videosback.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Photo {

  private String name;
  private long id;
  private String path;
  private String type;
  private Date createTime;
  private Date updateTime;
  private String absolutePath;


}
