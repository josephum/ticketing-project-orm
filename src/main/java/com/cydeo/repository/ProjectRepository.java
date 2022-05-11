package com.cydeo.repository;

import com.cydeo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);

//    @Transactional
//    Project save(Project project);

}
