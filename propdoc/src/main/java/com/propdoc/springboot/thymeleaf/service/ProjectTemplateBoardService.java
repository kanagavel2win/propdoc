package com.propdoc.springboot.thymeleaf.service;

import java.util.List;

import com.propdoc.springboot.thymeleaf.entity.ProjectTemplateActivityMaster;
import com.propdoc.springboot.thymeleaf.entity.ProjectTemplateBoard;

public interface ProjectTemplateBoardService {
	
	public ProjectTemplateBoard save(ProjectTemplateBoard obj);
	public ProjectTemplateBoard findById(Integer id);
	public List<ProjectTemplateBoard> findAll();
	public List<ProjectTemplateBoard> saveall(List<ProjectTemplateBoard> objList);
	public void deletenullrows();
	public void ProjectTemplateActivityMastersave(ProjectTemplateActivityMaster obj, int projecttemplatephaseid);
}