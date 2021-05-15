package com.example.readingpartner.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class PageBean {
    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int currPage;
    private List<VideoEntity> list;
}
