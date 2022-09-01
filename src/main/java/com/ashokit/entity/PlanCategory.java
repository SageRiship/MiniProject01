package com.ashokit.entity;

import java.time.LocalDate;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	

	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CRAETED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATE_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updatedate;
	
	
	}
