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

    //εεΊζε
    public static VideoUpdateResponse ok() {
        VideoUpdateResponse videoUpdateResponse = new VideoUpdateResponse();
        videoUpdateResponse.setMsg("success");
        videoUpdateResponse.setCode(0);
        return videoUpdateResponse;
    }
}
