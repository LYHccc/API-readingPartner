package com.example.readingpartner.Response;

import com.example.readingpartner.model.VideoEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class MyCollectResponse {
    private String msg;
    private int code;
    private List<VideoEntity> list;

    private MyCollectResponse(){}

    public static MyCollectResponse ok(List<VideoEntity> list) {
        MyCollectResponse myCollectResponse = new MyCollectResponse();
        myCollectResponse.setMsg("success");
        myCollectResponse.setCode(0);
        myCollectResponse.setList(list);
        return myCollectResponse;
    }
}
