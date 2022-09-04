package com.example.Kanban.Kanban.services;

import com.example.Kanban.Kanban.models.Tasks;
import com.example.Kanban.Kanban.repositories.ColumnsRepository;
import com.example.Kanban.Kanban.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;
    private ColumnsRepository columnsRepository;

    public List<Tasks> getAllTasks(Integer boardid) {
         return tasksRepository.findAllByBoardid(boardid);

    }
    public List<Tasks> getAllTasksByColumns(Integer boardid, Integer columnsid) {
        return tasksRepository.findAllByColumnIdAndBoardId(boardid, columnsid);

    }


    public void addTask(Tasks tasks) {
        tasks.setStatus("Todo");
        tasks.setColumnsid(1);
        tasksRepository.save(tasks);
    }

    public void deleteTask(Integer tasksid) {
        tasksRepository.deleteById(tasksid);
    }
}
