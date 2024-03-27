package com.xy.videosback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xy.videosback.entity.FileTree1;
import com.xy.videosback.entity.SearchHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper extends BaseMapper<FileTree1> {
    List<SearchHistory> searchHistory();

    int saveSearch(@Param("searchHistory") SearchHistory searchHistory);

    SearchHistory queryContent(@Param("path") String path);

    Integer updateSearch(@Param("searchHistory") SearchHistory searchHistory);
}
