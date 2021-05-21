package com.example.readingpartner.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VideoUpdateResponse {
    String msg;
    int code;

    private VideoUpdateResponse(){}

    //响应成功
    public static VideoUpdateResponse ok() {
        VideoUpdateResponse videoUpdateResponse = new VideoUpdateResponse();
        videoUpdateResponse.setMsg("success");
        videoUpdateResponse.setCode(0);
        return videoUpdateResponse;
    }
}
