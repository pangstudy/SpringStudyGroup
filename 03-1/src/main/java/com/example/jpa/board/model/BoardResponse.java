package com.example.jpa.board.model;

import com.example.jpa.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponse {

    private Long id;
    private String title;
    private String contents;

    public BoardResponse(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
    }
}
