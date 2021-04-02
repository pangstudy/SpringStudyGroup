package com.example.jpa.board.controller;

import com.example.jpa.board.entity.Board;
import com.example.jpa.board.model.BoardResponse;
import com.example.jpa.board.repositoy.BoardRepository;
import com.example.jpa.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class IndexController {

    public IndexController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("board", boardService.findAllDese());
        return "index";
    }

    @GetMapping("/board/save")
    public String boardSave() {
        return "board-save";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model) {

        BoardResponse board = boardService.findById(id);
        model.addAttribute("board", board);

//        Optional<Board> optionalBoard = boardRepository.findById(id);
//        Board board = optionalBoard.get();
//        model.addAttribute("board", board);

        return "board-update";
    }
}