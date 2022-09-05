package com.example.Kanban.Kanban.services;

import com.example.Kanban.Kanban.models.Tasks;
import com.example.Kanban.Kanban.repositories.TasksRepository;
import com.example.Kanban.Kanban.request.TaskUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;

    public List<Tasks> getAllTasks(Integer boardid) {
         return tasksRepository.findAllByBoardId(boardid);

    }


    public void addTask(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    public void deleteTask(Integer tasksid) {
        tasksRepository.deleteById(tasksid);
    }

    public Optional<Tasks> getTask(Integer taskid) {
        return tasksRepository.findById(taskid);
    }

    public void updateTask(Integer taskid, TaskUpdateRequest taskUpdateRequest) {
        Tasks task = tasksRepository.findById(taskid).orElseThrow(()->new IllegalStateException("Task ID does not exist"));
        task.setStatus(taskUpdateRequest.getStatus());
    }
}
