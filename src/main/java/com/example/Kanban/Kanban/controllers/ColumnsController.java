package com.example.Kanban.Kanban.controllers;

import com.example.Kanban.Kanban.models.Columns;
import com.example.Kanban.Kanban.services.ColumnsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/columns")
public class ColumnsController {
    private final ColumnsService columnsService;

    @GetMapping(path = "{boardid}")
    public List<Columns> getAllColumns(@PathVariable("boardid")Integer id){
        return columnsService.getAllColumns(id);
    }
    @PostMapping(path = "add")
    public void addColumn(@RequestBody Columns columns){
        columnsService.addColumn(columns);
    }

    @DeleteMapping(path = "delete/{columnsid}")
    public void deleteColummn(@PathVariable("columnsid") Integer columnsid){
        columnsService.deleteColumn(columnsid);
    }
}
