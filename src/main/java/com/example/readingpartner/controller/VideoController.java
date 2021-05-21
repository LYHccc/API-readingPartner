package com.example.readingpartner.controller;

import com.example.readingpartner.Response.MyCollectResponse;
import com.example.readingpartner.Response.VideoListResponse;
import com.example.readingpartner.Response.VideoUpdateResponse;
import com.example.readingpartner.model.Token;
import com.example.readingpartner.model.UpdateCountDTO;
import com.example.readingpartner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/videolist")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取视频列表
     */
    @PostMapping("/list")
    public VideoListResponse list(@RequestBody Token token) {
        return videoService.getVideoList(token.getToken());
    }

    /**
     * 更新视频点赞数和收藏数
     */
    @PostMapping("/updateCount")
    public VideoUpdateResponse update(@RequestBody UpdateCountDTO updateCountDTO) {
        return videoService.updateCount(updateCountDTO);
    }

    @GetMapping("/mycollect")
    public MyCollectResponse collectList() {
        return videoService.getCollectList();
    }
}
