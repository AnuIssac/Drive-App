package org.crce.interns.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="placement_statistics_schema.placement_statistics")

public class PlacementStats {
     @Id
     @Column(name="placment_stats_id")
	 String placment_stats_id ;
     @Column(name="company_id")
     int company_id;
     @Column(name="year")
	 
	  int year ;
     @Column(name="branch")
	 
     String branch ;
     @Column(name="no_applied")
	 
     int no_applied ;
     @Column(name="total_no_of_students")
	 
     int total_no_of_students ;
     @Column(name="no_selected")
	 
     int no_selected ;
     @Column(name="no_rejected")
	 
     int no_rejected ;
     @Column(name="no_joined")
	 
     int no_joined ;
     @Column(name="percentage_placed")
	  
     double percentage_placed;
     @Column(name="created_by")
	 
     String created_by ;
     @Column(name="created_date")
	 
     Date created_date ;
     @Column(name="modified_by")
	 
     String modified_by;
     @Column(name="modified_date")
	 
     Date modified_date;
	
	  
	  public String getPlacment_stats_id() {
		return placment_stats_id;
	}
	public void setPlacment_stats_id(String placment_stats_id) {
		this.placment_stats_id = placment_stats_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getNo_applied() {
		return no_applied;
	}
	public void setNo_applied(int no_applied) {
		this.no_applied = no_applied;
	}
	public int getTotal_no_of_students() {
		return total_no_of_students;
	}
	public void setTotal_no_of_students(int total_no_of_students) {
		this.total_no_of_students = total_no_of_students;
	}
	public int getNo_selected() {
		return no_selected;
	}
	public void setNo_selected(int no_selected) {
		this.no_selected = no_selected;
	}
	public int getNo_rejected() {
		return no_rejected;
	}
	public void setNo_rejected(int no_rejected) {
		this.no_rejected = no_rejected;
	}
	public int getNo_joined() {
		return no_joined;
	}
	public void setNo_joined(int no_joined) {
		this.no_joined = no_joined;
	}
	public double getPercentage_placed() {
		return percentage_placed;
	}
	public void setPercentage_placed(double percentage_placed) {
		this.percentage_placed = percentage_placed;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	
	}
