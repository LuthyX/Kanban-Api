package com.example.Kanban.Kanban.repositories;

import com.example.Kanban.Kanban.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    List<Tasks> findAllByColumnsId(Integer columnsid);

    @Query("SELECT t FROM Tasks t WHERE t.boardid = ?1 and t.columnsid = ?2")
    List<Tasks> findAllByColumnIdAndBoardId(Integer boardid, Integer columnsid);

    List<Tasks> findAllByBoardid(Integer boardid);
}
