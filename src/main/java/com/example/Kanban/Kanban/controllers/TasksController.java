package com.example.Kanban.Kanban.controllers;

import com.example.Kanban.Kanban.models.Tasks;
import com.example.Kanban.Kanban.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/tasks")
public class TasksController {
    private final TasksService tasksService;

    @GetMapping(path = "{boardid}")
    public List<Tasks> getAllTasks(@PathVariable("boardid") Integer boardid){
        return tasksService.getAllTasks(boardid);
    }

    @GetMapping(path = "{boardid}/{columnsid}")
    public List<Tasks> getAllTasksByColummns(@PathVariable("boardid") Integer boardid,
                                   @PathVariable("columnsid") Integer columnsid){
        return tasksService.getAllTasksByColumns(boardid,columnsid);
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
