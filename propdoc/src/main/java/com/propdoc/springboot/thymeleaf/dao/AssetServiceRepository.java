package com.propdoc.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propdoc.springboot.thymeleaf.entity.AssetService;

public interface AssetServiceRepository extends JpaRepository<AssetService,Integer>{

	//List<AssetService> findByAssetId(String assetid);

}
