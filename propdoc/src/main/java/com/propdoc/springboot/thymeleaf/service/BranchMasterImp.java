package com.propdoc.springboot.thymeleaf.service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.BranchMasterRepository;
import com.propdoc.springboot.thymeleaf.entity.BranchAccNo;
import com.propdoc.springboot.thymeleaf.entity.BranchMaster;
import com.propdoc.springboot.thymeleaf.pojo.emppojoPrivillage;

@Service
public class BranchMasterImp implements BranchMasterService {

	@Autowired
	BranchMasterRepository branchRepo;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public BranchMaster save(BranchMaster obj) {
		return branchRepo.save(obj);
	}

	@Override
	public BranchMaster findById(Integer id) {
		Optional<BranchMaster> obj = branchRepo.findById(id);

		BranchMaster bm = null;

		if (obj.isPresent()) {
			bm = obj.get();
			// ----- Object Validation------------------
			Optional<BranchMaster> privillageObject = Optional.ofNullable(privillageValidation(bm));
			if (privillageObject.isPresent()) {
				bm = privillageObject.get();
			}
		} else {
			throw new RuntimeException("Did find any records of Branch id " + id);
		}
		return bm;
	}

	@Override
	public List<BranchMaster> findAll() {

		List<BranchMaster> ls = new ArrayList<>();
		for (BranchMaster as : branchRepo.findAll()) {
			// ----- Object Validation------------------
			Optional<BranchMaster> privillageObject = Optional.ofNullable(privillageValidation(as));
			if (privillageObject.isPresent()) {
				ls.add(privillageObject.get());
			}
		}

		return ls;
	}

	@Override
	public int insertbranchContact(String dep, String phonenumber, String email, int branchid, boolean primary) {
		if (emppojoPrivillage.allowBranches.contains(branchid)) {
			final String sql = "INSERT INTO `branch_contact`(`department`, `email`, `phonenumber`, `id`,primarycontact) VALUES ('"
					+ dep + "','" + email + "','" + phonenumber + "'," + branchid + "," + primary + ")";

			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				return ps;
			}, keyHolder);

			return keyHolder.getKey().intValue();
		} else {
			return 0;
		}
	}

	@Override
	public int updatebranchContact(int id, String dep, String phonenumber, String email, boolean primary) {
		String sql = "UPDATE `branch_contact` SET `department`='" + dep + "',`email`='" + email + "',`phonenumber`='"
				+ phonenumber + "',primarycontact=" + primary + " WHERE branchcontactid=" + id;

		return jdbcTemplate.update(sql);
	}

	@Override
	public int deletebranchContact(int id) {
		String sql = "DELETE FROM `branch_contact` WHERE  branchcontactid=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int insertbranchFiles(String DocumentType, String DocumentNo, String FilePath, int branchid) {

		if (emppojoPrivillage.allowBranches.contains(branchid)) {

			final String sql = "INSERT INTO `branch_files`(`document_no`, `document_type`, `file_path`, `id`) VALUES ('"
					+ DocumentNo + "','" + DocumentType + "','" + FilePath + "'," + branchid + ")";

			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				return ps;
			}, keyHolder);

			return keyHolder.getKey().intValue();
		} else {
			return 0;
		}
	}

	@Override
	public int deletebranchFiles(int id) {
		String sql = "DELETE FROM `branch_files` WHERE  branchfilesid=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int insertbranchAccountdetails(int acid, String acno, String acname, String bankname, String branchname,
			String ifsccode, int branchid) {
		if (emppojoPrivillage.allowBranches.contains(branchid)) {
			if(acid ==0)
			{
				Optional<BranchMaster> bm = branchRepo.findById(branchid);
				
				if(bm.isPresent())
				{
					BranchMaster bmobj= bm.get();
					
					BranchAccNo baccno = new BranchAccNo();
					baccno.setAcname(acname);
					baccno.setAcno(acno);
					baccno.setBankname(bankname);
					baccno.setBranchname(branchname);
					baccno.setIfsccode(ifsccode);
					List<BranchAccNo> branchAccNols =bmobj.getBranchAccNo();
					branchAccNols.add(baccno); 
					bmobj.setBranchAccNo(branchAccNols);
					branchRepo.save(bmobj);
				}
				
				return 0;
			}else
			{
			String sql = "UPDATE `branch_acc_no` SET `acname`='" + acname + "',`acno`='" + acno + "',`bankname`='"
					+ bankname + "',`branchname`='" + branchname + "',`ifsccode`='" + ifsccode + "',`branchid`='"
					+ branchid + "' WHERE branch_accnoid=" + acid;
			return jdbcTemplate.update(sql);
			}
		} else {
			return 0;
		}
	}

	@Override
	public int getemployeeActivecount(int branchid) {
		if (emppojoPrivillage.allowBranches.contains(branchid)) {

			int result = 0;
			try {
				result = jdbcTemplate.queryForObject(
						"select count(*) as empcount from (select max(empjob.jobeffectivedate),empjob.employeeid,empjob.joblocation from employeejobinfo as empjob  group by employeeid,joblocation) t1 where joblocation="
								+ branchid,
						Integer.class);

			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		} else {
			return 0;
		}

	}

	private BranchMaster privillageValidation(BranchMaster obj) {

		if (emppojoPrivillage.allowBranches.contains(obj.getId())) {
			return obj;
		}
		return null;
	}
}
