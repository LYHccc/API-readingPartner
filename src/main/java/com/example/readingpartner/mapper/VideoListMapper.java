package com.example.readingpartner.mapper;

import com.example.readingpartner.model.VideoList;

import java.util.List;

public interface VideoListMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(VideoList record);

    VideoList selectByPrimaryKey(Integer vid);

    List<VideoList> selectAll();

    int updateByPrimaryKey(VideoList record);

    List<VideoList> selectCollectList();
}