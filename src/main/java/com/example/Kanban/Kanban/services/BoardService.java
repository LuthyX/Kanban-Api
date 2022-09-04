package com.example.Kanban.Kanban.services;

import com.example.Kanban.Kanban.models.Board;
import com.example.Kanban.Kanban.repositories.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public List<Board> getBoards(){
        return boardRepository.findAll();
    };

    public void addNewBoard(Board board) {
        boardRepository.save(board);
    }

    public Optional<Board> getBoard(Integer id) {
        boolean exists = boardRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Board with that id does not exist");
        }
        return boardRepository.findById(id);
    }

    public void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }
}
