package com.example.jpa.board.model;

import com.example.jpa.board.entity.Board;

import java.time.LocalDateTime;

public class BoardListResponse {
    private Long id;
    private String title;
    private LocalDateTime updateDate;

    public BoardListResponse(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.updateDate = entity.getUpdateDate();
    }
}
