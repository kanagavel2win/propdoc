package com.rvs.springboot.thymeleaf.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "leadmaster")
public class LeadMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column
	//private String ContactPerson;
	@Column
	private String Organization;
	@Column
	private String Title;
	@Column
	private String Source;
	@Column
	private String Reference;
	@Column
	private String Label;
	@Column
	private String notes;
	@Column
	private String purpose;
	@Column
	private String createddate;
	@Column
	private boolean movedtolead;
	@Column
	private int leadvalue;
	@Column
	private boolean backfromdeal;
	
	@Column
	int branch;
	
	@Column
	private String leadDate;	
	@Column
	private String status;	
	@Column
	private String tdate;
	@Column
	private String Location;
	@Column
	private String UNITS;
	@Column
	private String Area;
	@Column
	private String NatureofWork;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<LeadContact> leadContact;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<LeadFollowers> leadFollowers;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	@OrderBy("Fileid ASC")
	private List<LeadFiles> leadFiles;
	
	@Transient
	private String nextactivity;
	
	
	
	
	@Transient
	private String OrganizationName;

	@Transient
	private String ContactPersonName;
	
	@Transient
	private String ReferenceName;
	@Transient
	private String createddateMMddYYY;
	@Transient
	private String leaddateMMddYYY;
	@Transient
	private String branchname;
	
	@Transient
	private String leadfollowerids;
	@Transient
	private String tdateMMddYYY;
	@Transient
	private String leaddays;
	
}