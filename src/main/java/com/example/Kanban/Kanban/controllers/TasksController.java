package com.example.Kanban.Kanban.controllers;

import com.example.Kanban.Kanban.models.Tasks;
import com.example.Kanban.Kanban.request.TaskUpdateRequest;
import com.example.Kanban.Kanban.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/tasks")
public class TasksController {
    private final TasksService tasksService;

    @GetMapping(path = "/board/{boardid}")
    public List<Tasks> getAllTasks(@PathVariable("boardid") Integer boardid){
        return tasksService.getAllTasks(boardid);
    }
    @GetMapping(path = "{taskid}")
    public Optional<Tasks> getTask(@PathVariable("taskid") Integer taskid){
        return tasksService.getTask(taskid);
    }

    @PutMapping(path = "update/{taskid}")
    public void updateTask(@PathVariable("taskid") Integer taskid,
                            @RequestBody TaskUpdateRequest taskUpdateRequest){
        tasksService.updateTask(taskid, taskUpdateRequest);

    }


    @PostMapping(path = "add")
    public void addTask(@RequestBody Tasks tasks){
        tasksService.addTask(tasks);
    }

    @DeleteMapping(path = "delete/{tasksid}")
    public void deleteTask(@PathVariable("tasksid")Integer tasksid){
        tasksService.deleteTask(tasksid);
    }
}
