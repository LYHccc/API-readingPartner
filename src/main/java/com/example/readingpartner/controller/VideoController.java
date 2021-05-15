package com.example.readingpartner.controller;

import com.example.readingpartner.Response.VideoListResponse;
import com.example.readingpartner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/videolist")
    public VideoListResponse list() {
        return videoService.getVideoList();
    }
}
