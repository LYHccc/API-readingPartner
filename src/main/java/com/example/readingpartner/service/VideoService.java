package com.example.readingpartner.service;

import com.example.readingpartner.Response.VideoListResponse;
import com.example.readingpartner.mapper.VideoListMapper;
import com.example.readingpartner.model.PageBean;
import com.example.readingpartner.model.VideoEntity;
import com.example.readingpartner.model.VideoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoListMapper videoListMapper;

    public VideoListResponse getVideoList() {
        List<VideoList> videoLists = videoListMapper.selectAll();
        List<VideoEntity> videoEntityList = new ArrayList<>();
        for (VideoList videoList : videoLists) {
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.setVid(videoList.getVid());
            videoEntity.setVtitle(videoList.getVtitle());
            videoEntity.setAuthor(videoList.getAuthor());
            videoEntity.setCoverurl(videoList.getCoverUrl());
            videoEntity.setHeadurl(videoList.getHeadUrl());
            videoEntity.setCollectNum(videoList.getCollectNum());
            videoEntity.setLikeNum(videoList.getLikeNum());
            videoEntity.setCommentNum(videoList.getCommentNum());
            videoEntityList.add(videoEntity);
        }
        PageBean pageBean = new PageBean();
        pageBean.setTotalCount(videoLists.size());
        pageBean.setList(videoEntityList);
        return VideoListResponse.ok(pageBean);
    }
}
