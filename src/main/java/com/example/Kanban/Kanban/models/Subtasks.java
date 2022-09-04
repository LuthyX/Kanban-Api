package com.example.Kanban.Kanban.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Subtasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Boolean isCompleted;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tasksid", insertable=false, updatable = false)
    private Tasks tasks;
    private Integer tasksid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "boardid", insertable = false, updatable = false)
    private Board board;
    private Integer boardid;

}
