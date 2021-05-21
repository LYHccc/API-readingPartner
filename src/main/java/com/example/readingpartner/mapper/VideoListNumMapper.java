package com.example.readingpartner.mapper;

import com.example.readingpartner.model.VideoListNum;

import java.util.List;

public interface VideoListNumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoListNum record);

    VideoListNum selectByPrimaryKey(Integer id);

    List<VideoListNum> selectAll();

    int updateByPrimaryKey(VideoListNum record);

    /**
     * 根据视频id查询点赞、收藏数
     */
    VideoListNum selectByVid(Integer vid);

    /**
     * 根据视频id更新点赞、收藏数
     */
    int updateByVid(VideoListNum videoListNum);
}