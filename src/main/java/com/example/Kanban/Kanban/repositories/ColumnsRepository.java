package com.example.Kanban.Kanban.repositories;

import com.example.Kanban.Kanban.models.Columns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnsRepository extends JpaRepository<Columns, Integer> {

    List<Columns> findAllByBoardId(Integer id);


}
