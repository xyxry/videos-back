package com.xy.videosback.service;

import cn.hutool.json.JSONObject;
import com.xy.videosback.entity.SearchHistory;
import com.xy.videosback.util.ResponseResult;

import java.util.List;

public interface FileService {
    List<SearchHistory> searchHistory();

    void saveSearch(String path);

    SearchHistory queryContent(String path);

    Integer updateSearch(SearchHistory path);
}
