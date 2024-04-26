package com.propdoc.springboot.thymeleaf.service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.AssetMasterRepository;
import com.propdoc.springboot.thymeleaf.entity.AssetMaster;
import com.propdoc.springboot.thymeleaf.pojo.emppojoPrivillage;

@Service
public class AssetMasterImp implements AssetMasterService {

	@Autowired
	AssetMasterRepository assetRepo;

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public AssetMaster save(AssetMaster obj) {
		return assetRepo.save(obj);
	}

	@Override
	public AssetMaster findById(Integer id) {
		Optional<AssetMaster> obj = assetRepo.findById(id);

		AssetMaster bm = null;

		if (obj.isPresent()) {
			//-----  Object Validation------------------
			bm = obj.get();
			Optional<AssetMaster> privillageObject=	Optional.ofNullable(privillageValidation(bm));
			if (privillageObject.isPresent()) {
				bm=privillageObject.get();
			}
			
		} else {
			throw new RuntimeException("Did find any records of Asset id " + id);
		}
		return bm;
	}

	@Override
	public List<AssetMaster> findAll() {

		 List<AssetMaster> ls = new ArrayList<>();
		 for(AssetMaster as : assetRepo.findAll())
		 {
			//-----  Object Validation------------------
				Optional<AssetMaster> privillageObject=	Optional.ofNullable(privillageValidation(as));
				if (privillageObject.isPresent()) {
					ls.add(privillageObject.get());
				}
		 }
		return ls;
	}

	@Override
	public void updatetheAssetStatus(String status, int rowid, String updatetime, String StaffID) {

		String sql = "UPDATE `assetmaster` SET status='" + status + "' , lastupdate='" + updatetime + "',StaffID='"
				+ StaffID + "' WHERE asset_id=" + rowid;

		jdbctemplate.execute(sql);
	}

	@Override
	public void updatetheAssetStatus(String status, int rowid, String updatetime, String StaffID, String acondition) {

		String sql = "UPDATE `assetmaster` SET status='" + status + "' , lastupdate='" + updatetime + "',StaffID='"
				+ StaffID + "',acondition='" + acondition + "' WHERE asset_id=" + rowid;

		jdbctemplate.execute(sql);
	}

	@Override
	public int getmaxid() {

		return jdbctemplate.queryForObject("select IFNULL(max(asset_id),1) maxid from assetmaster", Integer.class);

	}

	@Override
	public List<AssetMaster> findbyStaffID(String StaffID) {
		return assetRepo.findByStaffID(StaffID);
	}

	@Override
	public int insertassetFiles(String FilePath, int assetid) {
		final String sql = "INSERT INTO `assetmasterfiles`(`files_attach`, `asset_id`) VALUES ('" + FilePath + "'," + assetid + ")";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbctemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			return ps;
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	@Override
	public int deleteassetFiles(int id) {
		String sql ="DELETE FROM `assetmasterfiles` where asset_fileid=" +id ;
		return jdbctemplate.update(sql);
	}

	@Override
	public List<AssetMaster> findByManyassetIds(List<Integer> assetidlist) {
	
		 List<AssetMaster> ls = new ArrayList<>();
		 for(AssetMaster as : assetRepo.findByManyassetIds(assetidlist))
		 {
			//-----  Object Validation------------------
				Optional<AssetMaster> privillageObject=	Optional.ofNullable(privillageValidation(as));
				if (privillageObject.isPresent()) {
					ls.add(privillageObject.get());
				}
		 }
		 
		return ls;
	}
	
	private AssetMaster privillageValidation(AssetMaster obj) {
		
		if(emppojoPrivillage.allowBranches.contains(Integer.parseInt(obj.getBranch()))) {
			return obj;	
		}
		return null;
	}

}