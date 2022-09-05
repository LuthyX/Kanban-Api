package com.example.Kanban.Kanban.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status= Status.TODO;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="boardid", insertable = false, updatable = false)
    private Board board;
    private Integer boardid;

    @OneToMany(mappedBy="tasks", cascade = CascadeType.ALL)
    private List<Subtasks> subtasks;


}
