package com.example.Kanban.Kanban.services;

import com.example.Kanban.Kanban.models.Subtasks;
import com.example.Kanban.Kanban.repositories.SubtasksRepository;
import com.example.Kanban.Kanban.request.SubRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubtasksService {
    private final SubtasksRepository subtasksRepository;
    public List<Subtasks> getAllSubTasks(Integer boardid, Integer tasksid) {
        return subtasksRepository.findAllByBoardidAndTasksid(boardid, tasksid);
    }

    public void addSubTasks(Subtasks subtasks) {
        subtasks.setIsCompleted(false);
        subtasksRepository.save(subtasks);
    }

    public void  updateSubTasks(Integer id, SubRequest subRequest){
        Subtasks subtask = subtasksRepository.findById(id).orElseThrow(()-> new IllegalStateException("Id does not exist"));
        subtask.setIsCompleted(subRequest.getIsCompleted());
        subtasksRepository.save(subtask);
    }

    public void deleteSubTasks(Integer subtasksid) {
        subtasksRepository.deleteById(subtasksid);
    }
}
