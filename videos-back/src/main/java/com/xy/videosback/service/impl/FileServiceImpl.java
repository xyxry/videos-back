package com.xy.videosback.service.impl;

import com.xy.videosback.entity.SearchHistory;
import com.xy.videosback.mapper.FileMapper;
import com.xy.videosback.service.FileService;
import com.xy.videosback.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper ;
    /**
     * 查询搜索记录
     * @return
     */
    @Override
    public List<SearchHistory> searchHistory(){
        List<SearchHistory> searchHistories = fileMapper.searchHistory();
        return searchHistories;
    }

    /**
     * 保存搜索记录
     * @param path
     */
    @Override
    public void saveSearch(String path){
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setContent(path);
        searchHistory.setId(SnowFlakeUtil.getSnowflakeId());
        searchHistory.setNum(1);
        searchHistory.setCreateTime(new Date());
        fileMapper.saveSearch(searchHistory);
    }

    /**
     * 搜索记录是否已存在
     * @param path
     * @return
     */
    @Override
    public SearchHistory queryContent(String path){
        return fileMapper.queryContent(path);
    }
    /**
     * 搜索记录是否已存在
     * @param
     * @return
     */
    @Override
    public Integer updateSearch(SearchHistory searchHistory){
        searchHistory.setCreateTime(new Date());
        searchHistory.setNum(searchHistory.getNum()+1);
        return fileMapper.updateSearch(searchHistory);
    }
}
