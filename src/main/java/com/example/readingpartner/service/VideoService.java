package com.example.readingpartner.service;

import com.example.readingpartner.Response.MyCollectResponse;
import com.example.readingpartner.Response.VideoListResponse;
import com.example.readingpartner.Response.VideoUpdateResponse;
import com.example.readingpartner.mapper.UserMapper;
import com.example.readingpartner.mapper.VideoListMapper;
import com.example.readingpartner.mapper.VideoListNumMapper;
import com.example.readingpartner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VideoListMapper videoListMapper;
    @Autowired
    private VideoListNumMapper videoListNumMapper;

    /**
     * 获取视频列表
     */
    public VideoListResponse getVideoList(String token) {
        User user = userMapper.selectByToken(token);
        if (user == null) {
            return VideoListResponse.ok();
        }
        List<VideoList> videoLists = videoListMapper.selectAll();
        List<VideoEntity> videoEntityList = new ArrayList<>();
        for (VideoList videoList : videoLists) {
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.setVid(videoList.getVid());
            videoEntity.setVtitle(videoList.getVtitle());
            videoEntity.setAuthor(videoList.getAuthor());
            videoEntity.setCoverurl(videoList.getCoverUrl());
            videoEntity.setHeadurl(videoList.getHeadUrl());
            videoEntity.setPlayurl(videoList.getPlayUrl());

            VideoSocialEntity videoSocialEntity = new VideoSocialEntity();
            VideoListNum videoListNum = videoListNumMapper.selectByVid(videoList.getVid());
            videoSocialEntity.setCollectNum(videoListNum.getCollectNum());
            videoSocialEntity.setLikeNum(videoListNum.getLikeNum());
            videoSocialEntity.setCommentNum(videoListNum.getCommentNum());
            videoSocialEntity.setFlagLike(videoListNum.getFlagLike());
            videoSocialEntity.setFlagCollect(videoListNum.getFlagCollect());

            videoEntity.setVideoSocialEntity(videoSocialEntity);
            videoEntityList.add(videoEntity);
        }
        PageBean pageBean = new PageBean();
        pageBean.setTotalCount(videoLists.size());
        pageBean.setList(videoEntityList);
        return VideoListResponse.ok(pageBean);
    }

    /**
     * 更新视频点赞收藏数
     */
    public VideoUpdateResponse updateCount(UpdateCountDTO updateCountDTO) {
        int vid = updateCountDTO.getVid();
        int type = updateCountDTO.getType();
        boolean flag = updateCountDTO.isFlag();
        int changeNum = updateCountDTO.getChangeNum();
        VideoListNum videoListNum = videoListNumMapper.selectByVid(vid);
        if (type == 1) {
            videoListNum.setCollectNum(changeNum);
            videoListNum.setFlagCollect(flag);
            videoListNumMapper.updateByVid(videoListNum);
        } else if(type == 2) {
            videoListNum.setLikeNum(changeNum);
            videoListNum.setFlagLike(flag);
            videoListNumMapper.updateByVid(videoListNum);
        }
        return VideoUpdateResponse.ok();
    }

    /**
     * 获取收藏的视频列表
     */
    public MyCollectResponse getCollectList() {
        List<VideoList> videoLists = videoListMapper.selectCollectList();
        List<VideoEntity> videoEntityList = new ArrayList<>();
        for (VideoList videoList : videoLists) {
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.setVid(videoList.getVid());
            videoEntity.setVtitle(videoList.getVtitle());
            videoEntity.setAuthor(videoList.getAuthor());
            videoEntity.setCoverurl(videoList.getCoverUrl());
            videoEntity.setHeadurl(videoList.getHeadUrl());
            videoEntity.setPlayurl(videoList.getPlayUrl());

            VideoSocialEntity videoSocialEntity = new VideoSocialEntity();

            videoEntity.setVideoSocialEntity(videoSocialEntity);
            videoEntityList.add(videoEntity);
        }
        return MyCollectResponse.ok(videoEntityList);
    }
}
