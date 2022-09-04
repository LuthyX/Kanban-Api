package com.example.Kanban.Kanban.repositories;

import com.example.Kanban.Kanban.models.Subtasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtasksRepository extends JpaRepository<Subtasks, Integer> {

    @Query("SELECT s FROM Subtasks s WHERE s.boardid = ?1 and s.tasksid = ?2")
    List<Subtasks> findAllByBoardidAndTasksid(Integer boardid, Integer tasksid);
}
