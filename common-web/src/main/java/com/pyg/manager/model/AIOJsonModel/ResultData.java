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
public class ResultData {

	@MyAnnotation(name = "门诊信息")
	private Clinic_info clinic_info;

	@MyAnnotation(name = "案件信息")
	private Case_info case_info;

	@MyAnnotation(name = "异常")
	private Questions Questions;

	@MyAnnotation(name = "其他信息")
	private Extension_info extension_info;

	private String IMG_XMLDATA;

	@MyAnnotation(name = "付费信息")
	private Pay_info pay_info;

	@MyAnnotation(name = "基本信息")
	private Base_info base_info;

	private Agency_info agency_info;

	private String myversion;

	@MyAnnotation(name = "事故者信息")
	private Accident_info accident_info;

	@MyAnnotation(name = "住院信息")
	private Inpatient_info inpatient_info;

	public void setClinic_info(Clinic_info clinic_info) {
		this.clinic_info = clinic_info;
	}
	public Clinic_info getClinic_info() {
		return clinic_info;
	}

	public void setCase_info(Case_info case_info) {
		this.case_info = case_info;
	}
	public Case_info getCase_info() {
		return case_info;
	}

	public void setQuestions(Questions Questions) {
		this.Questions = Questions;
	}
	public Questions getQuestions() {
		return Questions;
	}

	public void setExtension_info(Extension_info extension_info) {
		this.extension_info = extension_info;
	}
	public Extension_info getExtension_info() {
		return extension_info;
	}

	public void setIMG_XMLDATA(String IMG_XMLDATA) {
		this.IMG_XMLDATA = IMG_XMLDATA;
	}
	public String getIMG_XMLDATA() {
		return IMG_XMLDATA;
	}

	public void setPay_info(Pay_info pay_info) {
		this.pay_info = pay_info;
	}
	public Pay_info getPay_info() {
		return pay_info;
	}

	public void setBase_info(Base_info base_info) {
		this.base_info = base_info;
	}
	public Base_info getBase_info() {
		return base_info;
	}

	public void setAgency_info(Agency_info agency_info) {
		this.agency_info = agency_info;
	}
	public Agency_info getAgency_info() {
		return agency_info;
	}

	public void setMyversion(String myversion) {
		this.myversion = myversion;
	}
	public String getMyversion() {
		return myversion;
	}

	public void setAccident_info(Accident_info accident_info) {
		this.accident_info = accident_info;
	}
	public Accident_info getAccident_info() {
		return accident_info;
	}

	public void setInpatient_info(Inpatient_info inpatient_info) {
		this.inpatient_info = inpatient_info;
	}
	public Inpatient_info getInpatient_info() {
		return inpatient_info;
	}

}