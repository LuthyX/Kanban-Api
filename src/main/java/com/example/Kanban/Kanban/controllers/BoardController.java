package com.example.Kanban.Kanban.controllers;

import com.example.Kanban.Kanban.models.Board;
import com.example.Kanban.Kanban.services.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/boards")
@AllArgsConstructor
@CrossOrigin()
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getBoards(){
        return boardService.getBoards();
    }
    @GetMapping(path = "{id}")
    public Optional<Board> getBoard(@PathVariable("id") Integer id){
        return boardService.getBoard(id);
    }

    @PostMapping
    public void addNewBoard(@RequestBody Board board){
        boardService.addNewBoard(board);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBoard(@PathVariable("id") Integer id){
        boardService.deleteBoard(id);
    }
}
