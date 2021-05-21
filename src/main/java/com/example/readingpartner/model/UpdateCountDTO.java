package com.example.readingpartner.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UpdateCountDTO {
    private int vid;
    private int type;
    private boolean flag;
    private int changeNum;
}
