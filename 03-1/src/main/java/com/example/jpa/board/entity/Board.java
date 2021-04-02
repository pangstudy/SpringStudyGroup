package com.example.jpa.board.entity;

import jdk.vm.ci.meta.Local;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String contents;

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
