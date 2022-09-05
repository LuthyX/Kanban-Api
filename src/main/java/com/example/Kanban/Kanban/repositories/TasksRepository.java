package com.example.Kanban.Kanban.repositories;

import com.example.Kanban.Kanban.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {




    List<Tasks> findAllByBoardId(Integer boardid);
}
