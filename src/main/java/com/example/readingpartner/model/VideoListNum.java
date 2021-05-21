package com.example.readingpartner.model;

public class VideoListNum {
    private Integer id;

    private Integer vid;

    private Integer commentNum;

    private Integer likeNum;

    private Integer collectNum;

    private Boolean flagLike;

    private Boolean flagCollect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Boolean getFlagLike() {
        return flagLike;
    }

    public void setFlagLike(Boolean flagLike) {
        this.flagLike = flagLike;
    }

    public Boolean getFlagCollect() {
        return flagCollect;
    }

    public void setFlagCollect(Boolean flagCollect) {
        this.flagCollect = flagCollect;
    }
}