/**
  * Copyright 2019 bejson.com 
  */
package com.pyg.manager.model.AIOJsonModel;

import com.pyg.manager.commonutils.MyAnnotation;

/**
 * Auto-generated: 2019-11-07 14:8:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Clinic_record {

	@MyAnnotation(name = "手术信息")
	private Surgery_info surgery_info;
	
	@MyAnnotation(name = "最后治疗日期")
	private String end_date;
	
	@MyAnnotation(name = "最后治疗结果")
	private String accident_status;
	
	@MyAnnotation(name = "医院代码")
	private String hospital_code;
	
	@MyAnnotation(name = "首次就诊日期")
	private String first_date;
	
	@MyAnnotation(name = "门诊病人姓名")
	private String name;
	
	private String accident_id;
	
	@MyAnnotation(name = "门诊信息编号")
	private String seq;
	
	@MyAnnotation(name = "门诊病人性别")
	private String gender;
	
	@MyAnnotation(name = "费用信息")
	private Fee_info fee_info;
	
	@MyAnnotation(name = "门诊号")
	private String clinic_no;
	
	@MyAnnotation(name = "")
	private String accident_type;
	
	
	public void setSurgery_info(Surgery_info surgery_info) {
		this.surgery_info = surgery_info;
	}
	public Surgery_info getSurgery_info() {
		return surgery_info;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEnd_date() {
		return end_date;
	}

	public void setAccident_status(String accident_status) {
		this.accident_status = accident_status;
	}
	public String getAccident_status() {
		return accident_status;
	}

	public void setHospital_code(String hospital_code) {
		this.hospital_code = hospital_code;
	}
	public String getHospital_code() {
		return hospital_code;
	}

	public void setFirst_date(String first_date) {
		this.first_date = first_date;
	}
	public String getFirst_date() {
		return first_date;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setAccident_id(String accident_id) {
		this.accident_id = accident_id;
	}
	public String getAccident_id() {
		return accident_id;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeq() {
		return seq;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}

	public void setFee_info(Fee_info fee_info) {
		this.fee_info = fee_info;
	}
	public Fee_info getFee_info() {
		return fee_info;
	}

	public void setClinic_no(String clinic_no) {
		this.clinic_no = clinic_no;
	}
	public String getClinic_no() {
		return clinic_no;
	}

	public void setAccident_type(String accident_type) {
		this.accident_type = accident_type;
	}
	public String getAccident_type() {
		return accident_type;
	}

}