package com.example.Kanban.Kanban.services;

import com.example.Kanban.Kanban.models.Columns;
import com.example.Kanban.Kanban.repositories.BoardRepository;
import com.example.Kanban.Kanban.repositories.ColumnsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColumnsService {
    private ColumnsRepository columnsRepository;
    private BoardRepository boardRepository;
    public List<Columns> getAllColumns(Integer id) {
        return columnsRepository.findAllByBoardId(id);
    }


    public void addColumn(Columns columns) {
        columnsRepository.save(columns);
    }

    public void deleteColumn(Integer columnsid) {
        columnsRepository.deleteById(columnsid);
    }
}
