package com.xy.videosback.mapper;

import com.xy.videosback.entity.SearchHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {
    List<SearchHistory> searchHistory();

    int saveSearch(@Param("searchHistory") SearchHistory searchHistory);

    SearchHistory queryContent(@Param("path") String path);

    Integer updateSearch(@Param("searchHistory") SearchHistory searchHistory);
}
