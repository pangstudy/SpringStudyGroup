package com.example.jpa.board.controller;

import com.example.jpa.board.entity.Board;
import com.example.jpa.board.exception.BarodNotFoundException;
import com.example.jpa.board.model.BoardInput;
import com.example.jpa.board.model.BoardResponse;
import com.example.jpa.board.repositoy.BoardRepository;
import com.example.jpa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@EnableJpaAuditing
public class ApiBoardController {

    private final BoardService boardService;


    @PostMapping("/api/board")
    public Long addBoard(@RequestBody BoardInput boardInput) {
        return boardService.save(boardInput);
    }

    @GetMapping("/api/board/{id}")
    public BoardResponse findByBoard(@PathVariable Long id) {
        return boardService.findById(id);
    }


    @PutMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardInput boardInput) {
        return boardService.update(id, boardInput);
    }


    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return id;
    }

}
