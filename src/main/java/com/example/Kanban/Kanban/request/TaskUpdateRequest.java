package com.example.Kanban.Kanban.request;

import com.example.Kanban.Kanban.models.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequest {

    private String title;
    private String description;
    private Status status;
}

