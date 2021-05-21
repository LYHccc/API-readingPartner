package com.example.readingpartner.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VideoSocialEntity {
    private int commentNum;
    private int likeNum;
    private int collectNum;
    private boolean flagLike;
    private boolean flagCollect;
}
