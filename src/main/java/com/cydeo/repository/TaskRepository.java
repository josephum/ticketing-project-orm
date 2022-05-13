package com.cydeo.repository;

import com.cydeo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


}
