package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.ProjectTemplateBoard;

public interface ProjectTemplateBoardRepository extends JpaRepository<ProjectTemplateBoard,Integer>{

}
