package com.example.table1.api;

import com.example.table1.entity.Board;
import com.example.table1.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BoardController1 {


    @Autowired
    private BoardRepository boardRepository;

    //GET
    @GetMapping("/api/articles")
    public List<Board> index() {
        return boardRepository.findAll();
    }
    /*
    @PostMapping("/api/articles")
    public Board create(@RequestBody Board dto){
        Board board = dto.toEntity();
        return boardRepository.save(board);
    }*/

}
