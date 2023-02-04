package com.example.Kanban.Kanban.controllers;

import com.example.Kanban.Kanban.models.Subtasks;
import com.example.Kanban.Kanban.request.SubRequest;
import com.example.Kanban.Kanban.services.SubtasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/subtasks")
@CrossOrigin("*")
public class SubtasksController {
    private final SubtasksService subtasksService;

    @GetMapping(path = "{boardid}/{tasksid}")
    public List<Subtasks> getAllSubTasks(@PathVariable("boardid") Integer boardid,
                                         @PathVariable("tasksid") Integer tasksid){
        return subtasksService.getAllSubTasks(boardid, tasksid );
    }

    @PutMapping(path = "update/{id}")
    public void updateSubTasks(@PathVariable("id") Integer id, @RequestBody SubRequest subRequest){
        subtasksService.updateSubTasks(id, subRequest);
    }

    @PostMapping(path = "add")
     public void addSubTasks(@RequestBody Subtasks subtasks){
        subtasksService.addSubTasks(subtasks);
     }

     @DeleteMapping(path = "delete/{subtasksid}")
     public void deleteSubTasks(@PathVariable("subtasksid")Integer subtasksid){
        subtasksService.deleteSubTasks(subtasksid);
     }

}
