package com.propdoc.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.AssetMasterFiles;

public interface AssetFilesRepository extends JpaRepository<AssetMasterFiles,Integer>{

}
