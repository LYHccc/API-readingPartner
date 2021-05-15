package com.example.readingpartner.Response;

import com.example.readingpartner.model.PageBean;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VideoListResponse {
    String msg;
    int code;
    PageBean page;

    private VideoListResponse(){}

    //响应成功
    public static VideoListResponse ok(PageBean page) {
        VideoListResponse videoListResponse = new VideoListResponse();
        videoListResponse.setMsg("success");
        videoListResponse.setCode(0);
        videoListResponse.setPage(page);
        return videoListResponse;
    }

    public static VideoListResponse ok() {
        return VideoListResponse.ok(null);
    }
}
