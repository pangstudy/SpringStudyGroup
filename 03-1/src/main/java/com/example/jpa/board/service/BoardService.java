package com.example.jpa.board.service;

import com.example.jpa.board.entity.Board;
import com.example.jpa.board.model.BoardInput;
import com.example.jpa.board.model.BoardListResponse;
import com.example.jpa.board.model.BoardResponse;
import com.example.jpa.board.repositoy.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardInput boardInput) {
        return boardRepository.save(boardInput.toEntity()).getId();
    }

    public BoardResponse findById(Long id){
        Board entity = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new BoardResponse(entity);
    }


    @Transactional
    public Long update(Long id, BoardInput boardInput){
        Board board = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        board.update(boardInput.getTitle(), boardInput.getContents());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        boardRepository.delete(board);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponse> findAllDese(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponse::new)
                .collect(Collectors.toList());
    }
}
